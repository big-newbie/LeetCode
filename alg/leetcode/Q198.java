package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-08-15
 */
public class Q198 {
    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return rob(nums, nums.length - 1);
//        return rob1(nums);
    }

    private static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    private static int rob(int[] nums, int e) {
        if (e == 0) {
            return nums[0];
        }
        if (e == 1) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        return Math.max(rob(nums, e - 1), rob(nums, e - 2) + nums[e]);
    }

    public static void main(String[] args) {
        System.out.println(2 >> 1);
        int[] array = {1, 2, 3, 1};
        System.out.println(rob(array));

        array = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(array));
        array = new int[]{2, 3, 2};
        System.out.println(rob(array));
        array = new int[]{};
        System.out.println(rob(array));


        array = new int[50];
        for (int i = 0; i < 50; i++) {
            array[i] = i;
        }
        System.out.println(rob(array));
    }
}
