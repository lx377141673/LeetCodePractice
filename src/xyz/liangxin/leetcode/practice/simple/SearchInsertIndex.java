package xyz.liangxin.leetcode.practice.simple;


/**
 * 题目:
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsertIndex {


    public static void main(String[] args) {
        int[] nums={1,3,5,7,9};
        System.out.println(nums.length);
        System.out.println(searchInsert(nums,2));
    }
    public static int searchInsert(int[] nums, int target) {
        int min=0;
        int max=nums.length-1;
        int result=0;
        while(max>=min){
            int a=min+((max-min)>>1);
            if(nums[a]==target){
                return a;
            }else if(nums[a]<target){
                min=a+1;
                result=min;
            }else if(nums[a]>target){
                max=a;
                result=max;
            }
        }
//        if(nums[result]<target){
//            result++;
//        }

        return result;
    }
}
