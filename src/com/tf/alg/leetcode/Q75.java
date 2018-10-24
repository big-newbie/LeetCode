package com.tf.alg.leetcode;

import java.util.Arrays;

/**
 * Created by tingfang
 * 2018-10-24
 */
public class Q75 {
    private static void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        for (int num : nums) {
            if (num == 0) {
                i++;
            } else if (num == 1) {
                j++;
            } else {
                k++;
            }
        }
        int index = 0;
        while (i-- > 0) {
            nums[index++] = 0;
        }
        while (j-- > 0) {
            nums[index++] = 1;
        }
        while (k-- > 0) {
            nums[index++] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println("nums = " + Arrays.toString(nums));
        nums = new int[]{0, 0};
        sortColors(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
