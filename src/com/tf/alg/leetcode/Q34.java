package com.tf.alg.leetcode;

import java.util.Arrays;

/**
 * Created by tingfang
 * 2018-11-15
 */
public class Q34 {
    private static int[] searchRange(int[] nums, int target) {
        int[] indexes = new int[2];
        indexes[0] = -1;
        indexes[1] = -1;
        if (nums == null || nums.length == 0) {
            return indexes;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int m = (i + j) >> 1;
            if (nums[m] > target) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                indexes[0] = findLeft(nums, i, m, target);
                indexes[1] = findRight(nums, m, j, target);
                return indexes;
            }
        }
        if (nums[i] == target) {
            indexes[0] = i;
            indexes[1] = i;
        }
        return indexes;
    }

    private static int findLeft(int[] nums, int i, int j, int target) {//始终保证 target 区间内
        while (i < j) {
            int m = (i + j) >> 1;
            if (nums[m] == target) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    private static int findRight(int[] nums, int i, int j, int target) {//始终保证 target 区间内
        while (i < j) {
            int m = (i + j + 1) >> 1;
            if (nums[m] == target) {
                i = m;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8};
        System.out.println(Arrays.toString(searchRange(nums, 6)));
        System.out.println(Arrays.toString(searchRange(nums, 8)));
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }
}