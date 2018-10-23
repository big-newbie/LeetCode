package com.tf.alg.leetcode;

import java.util.Arrays;

/**
 * Created by tingfang
 * 2018-08-13
 */
public class Q27 {
    static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                cur++;
            } else if (cur != 0) {
                nums[i - cur] = nums[i];
            }
        }
        return nums.length - cur;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 2, 3};
        System.out.println("removeElement(" + Arrays.toString(a) + ", 3) = " + removeElement(a, 3));
        System.out.println(Arrays.toString(a));
        int[] b = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println("removeElement(" + Arrays.toString(b) + ",2) = " + removeElement(b, 2));
        System.out.println(Arrays.toString(b));
    }
}