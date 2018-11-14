package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-11-14
 */
public class Q33 {
    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int k = nums.length - 1;
        while (i < k) {
            int j = (i + k) >> 1;
            int low = nums[i];
            int mid = nums[j];
            int high = nums[k];
            if (low == target) {
                return i;
            } else if (high == target) {
                return k;
            } else if (mid == target) {
                return j;
            } else if (mid > low) {
                if (mid > target && target > low) {
                    k = j - 1;
                } else {
                    i = j + 1;
                }
            } else {
                if (mid < target && target < high) {
                    i = j + 1;
                } else {
                    k = j - 1;
                }
            }
        }
        return nums[i] == target ? i : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 8, 0, 1, 2};
        for (int i = -1; i < 10; i++) {
            System.out.println("search(nums," + i + ") = " + search(nums, i));
        }
    }
}
