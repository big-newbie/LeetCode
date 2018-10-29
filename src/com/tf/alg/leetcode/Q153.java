package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-29
 */
public class Q153 {
    private static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int i = 0;
        int j = nums.length - 1;
        if (nums[i] < nums[j]) {
            return nums[i];
        }
        while (i < j) {
            int m = i + ((j - i + 1) >> 1);
            if (nums[m] > nums[0]) {
                i = m + 1;
            } else {
                if (nums[m - 1] < nums[0]) {
                    j = m - 1;
                } else {
                    return nums[m];
                }
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
//        System.out.println("findMin(new int[]{1,2,3,4,5}) = " + findMin(new int[]{1, 2, 3, 4, 5}));
        System.out.println("findMin(new int[]{ 4, 5, 1, 2, 3}) = " + findMin(new int[]{4, 5, 1, 2, 3}));
        System.out.println("findMin(new int[]{3, 4, 5, 1, 2}) = " + findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println("findMin(new int[]{5, 1, 2, 3, 4}) = " + findMin(new int[]{5, 1, 2, 3, 4}));
        System.out.println("findMin(new int[]{2, 3, 4, 5, 1}) = " + findMin(new int[]{2, 3, 4, 5, 1}));
    }
}
