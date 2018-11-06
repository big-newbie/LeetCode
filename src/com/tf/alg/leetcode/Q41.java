package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-11-06
 */
public class Q41 {
    private static int firstMissingPositive1(int[] nums) {// O(n) time O(n) space
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int[] count = new int[nums.length];
        for (int i : nums) {
            if (i > 0 && i <= nums.length) {
                count[i - 1] = -1;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != -1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}