package com.matrix.easy;

/**
 * @创建人 netboy
 * @创建时间 2020/7/21
 * @描述  寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *  
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 */
public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        if(l1%2 == 0 && l2%2 ==0){
            if(l1 == 0 &&  l2 != 0){
                int r = l2/2;
                int l = r-1;
                return (nums2[r] + nums2[l])/2.0;
            }else if(l2 == 0 &&  l1 != 0) {
                return findMedianSortedArrays(nums2,nums1);
            }else {
                int ll1 = nums1[l1/2-1];
                int ll2 = nums2[l2/2-1];
                int rr1 = nums1[l1/2];
                int rr2 = nums2[l2/2];
                int min = ll1 <= ll2 ? ll2 : ll1;
                int max = rr1 <= rr2 ? rr1: rr2;
                return (min+max) / 2.0;
            }

        }else if(l1%2 != 0 && l2%2 ==0){
            int min1 = nums1[(l1-1)/2];
            if(l2 == 0){
                return min1;
            }
            int l = nums2[l2/2-1];
            int r = nums2[l2/2];
            if(min1 >=l && min1 <= r){
                return min1;
            }else if(min1 < l || min1 > r){
                return (l+r)/2.0;
            }
        }else if(l1%2 == 0 && l2%2 !=0){
            return findMedianSortedArrays(nums2,nums1);
        }else if (l1%2 != 0 && l2%2 !=0){
            return (nums1[(l1-1)/2] + nums2[(l2-1)/2]) /2.0;
        }
        return 0.0;
    }
}
