package com.tf.alg.leetcode;

import java.util.Arrays;

/**
 * Created by tingfang
 * 2018-09-13
 */
public class Q16 {
    private static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int ret = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    if (sum - target < diff) {
                        diff = sum - target;
                        ret = sum;
                    }
                    k--;
                } else {
                    if (target - sum < diff) {
                        diff = target - sum;
                        ret = sum;
                    }
                    j++;
                }
            }
            for (; i < nums.length - 2 && nums[i] == nums[i + 1]; i++) {}
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        nums = new int[]{0, 1, 2};
        nums = new int[]{-1, 0, 1, 1, 55};
        System.out.println(threeSumClosest(nums, 3));
    }
}