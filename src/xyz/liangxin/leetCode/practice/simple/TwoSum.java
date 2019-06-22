package xyz.liangxin.leetCode.practice.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目
 * 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {-2, 7, 11, 15};
        int target = 18;
        int[] result1 = twoSumOne(nums, target);
        System.out.println("结果1:[" + result1[0] + "," + result1[1] + "].");
        int[] result2 = twoSumTwo(nums, target);
        System.out.println("结果2:[" + result2[0] + "," + result2[1] + "].");
        int[] result3 = twoSumThree(nums, target);
        System.out.println("结果3:[" + result3[0] + "," + result3[1] + "].");
    }

    public static int[] twoSumOne(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSumTwo(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int shortOf = target - nums[i];
            if (map.containsKey(shortOf) && map.get(shortOf) != i) {
                return new int[]{i,map.get(shortOf) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int [] twoSumThree(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int shortOf=target-nums[i];
            if(map.containsKey(shortOf) && map.get(shortOf) != i){
                return new int[]{map.get(shortOf),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
