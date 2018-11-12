package com.tf.alg.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-11-12
 */
public class Q15 {
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            int m = i + 1;
            int n = len - 1;
            while (m < n) {
                int low = nums[m];
                int high = nums[n];
                int sum = nums[i] + low + high;
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], low, high));
                    n--;
                    m++;
                    while (m < n && nums[n] == high) {
                        n--;
                    }
                    while (m < n && nums[m] == low) {
                        m++;
                    }
                } else if (sum > 0) {
                    n--;
                } else {
                    m++;
                }
            }
            while (i < len - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println("threeSum(new int[]{-1, 0, 1, 2, -1, -4}) = " + threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("threeSum(new int[]{-2,0,0,2,2}) = " + threeSum(new int[]{-2, 0, 0, 2, 2}));
        System.out.println("threeSum(new int[]{1,-1,-1,0}) = " + threeSum(new int[]{1, -1, -1, 0}));
    }
}
