package com.tf.alg.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-11-14
 */
public class Q18 {
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length < 4) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int m = j + 1, n = nums.length - 1; m < n; ) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        m++;
                        n--;
                        while (m < n && nums[m - 1] == nums[m]) {m++;}
                        while (m < n && nums[n + 1] == nums[n]) {n--;}
                    } else if (sum > target) {
                        n--;
                    } else {
                        m++;
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) {j++;}
            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) {i++;}
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}