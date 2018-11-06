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

    private static int firstMissingPositive(int[] nums) {// O(n) time O(1) space
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            int prev = nums[i];
            while (prev > 0 && prev <= len) {
                int temp = nums[prev - 1];
                nums[prev - 1] = -1;
                prev = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != -1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        System.out.println("firstMissingPositive(new int[]{1,2,0}) = " + firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println("firstMissingPositive(new int[]{3,4,-1,1}) = " + firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println("firstMissingPositive(new int[]{7,8,9,11,12}) = " + firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println("firstMissingPositive(new int[]{1,2,3,4,5}) = " + firstMissingPositive(new int[]{1, 2, 3, 4, 5}));
        System.out.println("firstMissingPositive(new int[]{2147483647}) = " + firstMissingPositive(new int[]{2147483647}));
    }
}