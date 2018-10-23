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
        int ret = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int low = i + 1;
            int high = len - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                int temp = target - sum;
                if (temp == 0) {
                    return sum;
                }
                if (Math.abs(temp) < diff) {
                    diff = Math.abs(temp);
                    ret = sum;
                }
                if (temp > 0) {
                    low++;
                } else {
                    high--;
                }
            }
            while (i < len - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
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
