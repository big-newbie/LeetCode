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
        int i = 0;
        int j = height.length - 1;
        int l = i;
        int r = j;
        int max = Math.min(height[l], height[r]) * (r - l);
        while (i < j) {
            while (i < j && height[i] < height[j] && height[i] * (r - i) <= max) {
                i++;
            }
            if (height[i] * (r - i) > max) {
                max = height[i] * (r - i);
                l = i;
            }
            if (height[i] < height[j]) {
                i++;
                continue;
            }
            while (i < j && height[j] < height[i] && height[j] * (j - l) <= max) {
                j--;
            }
            if (height[j] * (j - l) > max) {
                max = height[j] * (j - l);
                r = j;
            }
            if (height[j] < height[i]) {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(array));
        System.out.println(maxArea(new int[]{1, 5, 7, 2, 8, 1, 9}));
    }
}
