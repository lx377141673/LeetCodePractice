package xyz.liangxin.leetCode.practice.simple;

import java.util.Random;

/**
 * 题目:
 *
 * 278. 第一个错误的版本
 *
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。 
 * @author  liangxin
 */
public class FirstBadVersion {

    public static int errorVersion=0;

    /**
     * 验证 当前版本是否是 错误版本
     * @param version
     * @return
     */
    public static boolean isBadVersion(int version){
//        if(version>=4){
//            return true;
//        }
//        return false;

        return version>=errorVersion;
    }


    public static void main(String[] args) {
        // 指定当前最终版本
        int endVersion=Integer.MAX_VALUE;
        int min=1;
        int max=endVersion;
//        // 随机生成第一个错误版本 号
//        errorVersion=endVersion<=1?endVersion:new Random().nextInt(max-min)+min;
//
//        System.out.println("第一个错误版本:"+errorVersion);
//
//        long begin=System.currentTimeMillis();
//        System.out.println("计算的第一个错误版本: "+firstBadVersion(endVersion));
//        System.out.println(System.currentTimeMillis()-begin);
        System.out.println(min=max);

    }


    public static int firstBadVersion(int n) {
        int min = 1;
        int maxVersion = n;

        while (maxVersion>min) {
            int mediant = min + ((maxVersion - min) /2);
            if (isBadVersion(mediant)) {
                maxVersion = mediant;
            } else {
                min = mediant+1;
            }
        }
        return maxVersion;
    }


}
