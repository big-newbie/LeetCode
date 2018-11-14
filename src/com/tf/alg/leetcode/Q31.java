package com.tf.alg.leetcode;

import java.util.Arrays;

/**
 * Created by tingfang
 * 2018-11-14
 */
public class Q31 {
    private static void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int j = nums.length - 1;
        if (i >= 0) {
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
            j = nums.length - 1;
        }
        for (i++; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
