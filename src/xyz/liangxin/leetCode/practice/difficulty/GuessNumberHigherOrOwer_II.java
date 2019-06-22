package xyz.liangxin.leetCode.practice.difficulty;




/**
 *
 *  题目:
 * 375. 猜数字大小 II
 *
 * 我们正在玩一个猜数游戏，游戏规则如下：
 *
 * 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 *
 * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 *
 * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
 *
 * 示例:
 *
 * n = 10, 我选择了8.
 *
 * 第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
 * 第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
 * 第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。
 *
 * 游戏结束。8 就是我选的数字。
 *
 * 你最终要支付 5 + 7 + 9 = 21 块钱。
 * 给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。
 *
 *
 */
public class GuessNumberHigherOrOwer_II {

    public static int selectNum=0;

    public static void main(String[] args) {
        int endNum=10000;
//        selectNum=endNum==1?endNum:new Random().nextInt(endNum-1)+1;

//        endNum=1;
//        selectNum=1;
//        System.out.println(selectNum);
  //     System.out.println(getMoneyAmount3(endNum));
        System.out.println(getMoneyAmount5(endNum));
    }

    int maxMoney=0;
    int n=1;

    public static int getMoneyAmount4(int n) {

//        getMoneyAmount(n,selectNum)

        return a(1,n);
    }

    public static int a(int num,int n){
        if(num>n){
            return 0;
        }
        selectNum=num;
        int min=1;
        int max=n;
        int money=0;
        while (max>=min){
            int a=min+((max-min)>>1);

            switch (guess(a)){
                case 0:
                    return Math.max(money,a(++num,n));
                case 1:
                    min=a+1;
                    break;
                case -1:
                    max=a;
                    break;
            }
            money+=a;
        }

        return money;
    }

    /**
     * @param num
     * @return -1 : 我的数字比较小
     * 1 : 我的数字比较大
     * 0 : 恭喜！你猜对了！
     */
    public static int guess2(int num) {
        if (num == selectNum) {
            return 0;
        } else if (num < selectNum) {
            return 1;
        } else {
            return -1;
        }
    }









    public static int getMoneyAmount(int n) {

        int min=1;
        int max=n;
        int money=0;
        while (max>=min){
            int a=min+((max-min)>>1);

            switch (guess(a)){
                case 0:
                    System.out.println(a);
                    return money;
                case 1:
                    min=a+1;
                    break;
                case -1:
                    max=a;
                    break;
            }
            money+=a;
        }

        return money;
    }






    public static int getMoneyAmount2(int n) {
        if (n == 1) {
            return 0;
        }
        int dp[][] = new int[n+1][n+1];

        for(int l = 1 ; l <= n ; l++){

            for(int i = 1 ; i <= n ; i++){

                int j = i+l;

                if(j > n) {break;}

                dp[i][j] = Integer.MAX_VALUE;

                int cost = 10;
                int left = 0;
                int right = 0;
                for(int k = i ; k<= j ; k++){

                    if(k>i){ left = dp[i][k-1];}
                    if(k<j) {right = dp[k+1][j];}
                    dp[i][j] = Math.min(dp[i][j], Math.max(left, right)+k);

                }


            }
        }
        return dp[1][n];
    }

    /**
     * @param num
     * @return -1 : 我的数字比较小
     * 1 : 我的数字比较大
     * 0 : 恭喜！你猜对了！
     */
    public static int guess(int num) {
        if (num == selectNum) {
            return 0;
        } else if (num < selectNum) {
            return 1;
        } else {
            return -1;
        }
    }



    public static Integer[][] memo;
    public static int getMoneyAmount3(int n) {
        memo = new Integer[n + 1][n + 1];
        return backtrack(1, n);
    }

    public static int backtrack(int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i + (j - i) / 2; k <= j; k++) {
            int max = Math.max(backtrack(i, k - 1), backtrack(k + 1, j)) + k;
            min = Math.min(min, max);
        }
        memo[i][j] = min;
        return min;
    }



    public  static int getMoneyAmount5(int n) {
        /**
         dp[i][j]表示从[i,j]中猜出正确数字所需要的最少花费金额.(dp[i][i] = 0)
         假设在范围[i,j]中选择x, 则选择x的最少花费金额为: max(dp[i][x-1], dp[x+1][j]) + x
         用max的原因是我们要计算最坏反馈情况下的最少花费金额(选了x之后, 正确数字落在花费更高的那侧)

         初始化为(n+2)*(n+2)数组的原因: 处理边界情况更加容易, 例如对于求解dp[1][n]时x如果等于1, 需要考虑dp[0][1](0不可能出现, dp[0][n]为0)
         而当x等于n时, 需要考虑dp[n+1][n+1](n+1也不可能出现, dp[n+1][n+1]为0)

         如何写出相应的代码更新dp矩阵, 递推式dp[i][j] = max(max(dp[i][x-1], dp[x+1][j]) + x), x~[i:j], 可以画出矩阵图协助理解, 可以发现
         dp[i][x-1]始终在dp[i][j]的左部, dp[x+1][j]始终在dp[i][j]的下部, 所以更新dp矩阵时i的次序应当遵循bottom到top的规则, j则相反, 由于
         i肯定小于等于j, 所以我们只需要遍历更新矩阵的一半即可(下半矩阵)
         **/
        int[][] dp = new int[n+2][n+2];
        for(int i = n; i >= 1; --i) {
            for(int j = i; j <= n; ++j) {
                if(i == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int x = i; x <= j; ++x) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][x - 1], dp[x + 1][j]) + x);
                    }
                }
            }
        }
        return dp[1][n];
    }




}
