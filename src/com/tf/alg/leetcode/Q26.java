package com.tf.alg.leetcode;

import java.util.Arrays;

/**
 * Created by tingfang
 * 2018-09-16
 */
public class Q26 {

    private static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int len = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[len] != nums[i]) {
                nums[++len] = nums[i];
                count = 1;
            } else if (count == 1) {
                count++;
                nums[++len] = nums[i];
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}