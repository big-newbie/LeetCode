package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-24
 */
public class Q55 {
    private static boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int index = 0;
        int cur = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums.length - i - 1) {
                return true;
            }
            if (cur + index < nums[i] + i) {
                cur = nums[i];
                index = i;
            }
            if (cur == i - index) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("canJump(new int[]{2,3,1,1,4}) = " + canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println("canJump(new int[]{3,2,1,0,4}) = " + canJump(new int[]{3, 2, 1, 0, 4}));
    }
}