package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-08-16
 */
public class Q11 {
    private static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int ret = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            ret = Math.max(ret, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                ret = Math.max(ret, height[i] * (j - i));
                i++;
            } else {
                ret = Math.max(ret, height[j] * (j - i));
                j--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(array));
        System.out.println(maxArea(new int[]{1, 5, 7, 2, 8, 1, 9}));
    }
}
