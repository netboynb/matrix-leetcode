package com.matrix.easy;

import java.util.*;

/**
 * @创建人 netboy
 * @创建时间 2020/7/18
 * @描述
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {

    public static int[]  twoSum(int[] nums, int target) {

        int x=0,y=0;
        boolean flag = false;
        for(int i = 0;i < nums.length - 1;i++ ){
            for(int j = i+1;j < nums.length; j++){
                int result = nums[i] + nums[j];
                if( result == target){
                    y = j;
                    flag = true;
                    break;
                }
            }
            if(flag){
                x= i;
                break;
            }
        }
        int[] intArray = new int[] {x,y};
        return flag ? intArray : null;
    }
    public static int[]  twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length-1;i++){
            map.put(nums[i],i);
            int value = target - nums[i+1];
            Integer result = map.get(value);
            if(result != null){
                return  new int[] {result,i+1};
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        int[] intArray = new int[] {2,12,13,7,11,15};

        int[] reuslt = Solution1.twoSum2(intArray,9);
        for(int i=0;i<reuslt.length;i++){
            System.out.print(reuslt[i]+" ");
        }
    }
}
