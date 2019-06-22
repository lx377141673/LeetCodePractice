package xyz.liangxin.leetCode.practice.simple;

/**
 * 题目
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 *  示例 1:
 *      输入: 123
 *      输出: 321
 *  示例 2:
 *      输入: -123
 *      输出: -321
 *  示例 3:
 *      输入: 120
 *      输出: 21
 * 注意:
 *      假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2~31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInteger {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        Integer max = 2017483647;
//        Integer min = -2147483648;
        Integer num = -2017;
        System.out.println(String.valueOf(num));
        System.out.println(reverseOne(num));
        System.out.println(reverseTwo(num));

    }

    public static int reverseOne(int x) {
        String numStr = String.valueOf(x);
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = numStr.length() - 1; i >= 0; i--) {
            char c = numStr.charAt(i);
            if ('-' == c) {
                stringBuffer.insert(0, "-");
            } else {
                stringBuffer.append(c);
            }
        }
        Long result = Long.valueOf(stringBuffer.toString());
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : result.intValue();
    }

    public static int reverseTwo(int x) {
        int result = 0;
        while (x != 0) {
            int pop=x%10;
            x/=10;
            if(result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && pop >7)){
                return 0;
            }
            if(result<Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && pop <-8)){
                return 0;
            }
            result=result*10+pop;
        }
        return result;
    }



}
