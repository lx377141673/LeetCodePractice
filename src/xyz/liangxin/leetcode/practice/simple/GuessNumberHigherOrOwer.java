package xyz.liangxin.leetcode.practice.simple;

import java.util.Random;

/**
 * 题目:
 * <p>
 * 374. 猜数字大小
 * <p>
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * <p>
 *
 * 这题中出现的 -1 : 我的数字比较小 1 : 我的数字比较大 0 : 恭喜！你猜对了！ -1指的是真实的结果比较小（即你猜的结果大），而不是你猜的小。
 *
 * -1 : 我的数字比较小  --> 即 你的数字比较大
 * 1 : 我的数字比较大   --> 即 你的数字比较小
 * 0 : 恭喜！你猜对了！ --> 即 两数相等
 * 示例 :
 * <p>
 * 输入: n = 10, pick = 6
 * 输出: 6
 */
public class GuessNumberHigherOrOwer {

    public static int selectNum  = 0;

    public static void main(String[] args) {
        int endNum = Integer.MAX_VALUE;
        int min = 1;
        int max = endNum;
        // 随机生成第一个错误版本 号
        selectNum = endNum <= 1 ? endNum : new Random().nextInt(max - min) + min;

        selectNum=6;
        endNum=10;

        System.out.println("我的数字:" + selectNum);
        System.out.println("我猜的数字:"+guessNumber(endNum));
    }

    public static int guessNumber(int n) {
        int min=1;
        int max=n;
        while (max>=min){
            int a=min+((max-min)>>1);
            int result=guess(a);
            switch (result){
                case 0:
                    return a;
                case -1:
                    max=a;
                    break;
                case 1:
                    min=a+1;
                    break;
            }
        }
        return 0;
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








}
