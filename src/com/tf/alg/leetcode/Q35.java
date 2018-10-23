package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-08-14
 */
public class Q35 {
    private static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = j - (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i == nums.length) {
            i = nums.length - 1;
        }
        return target > nums[i] ? i + 1 : i;
    }

    public static void main(String[] args) {
        System.out.println("searchInsert(new int[]{1,3,5,6},5) = " + searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println("searchInsert(new int[]{1,3,5,6},2) = " + searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println("searchInsert(new int[]{1,3,5,6},7) = " + searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println("searchInsert(new int[]{1,3,5,6},0) = " + searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(searchInsert(new int[]{1, 3}, 4));
    }
}