package com.tf.alg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tingfang
 * 2018-11-13
 */
public class Q1 {
    private static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException();
        }
//        return ts1(nums, target);
        return ts2(nums, target);
    }

    private static int[] ts2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length * 2);
        map.put(nums[0], 0);
        Integer t;
        for (int i = 1; i < nums.length; i++) {
            t = map.get(target - nums[i]);
            if (t != null) {
                return new int[]{t, i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }

    private static int[] ts1(int[] nums, int target) {
        int[] temp = nums.clone();
        Arrays.sort(nums);
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        for (int i = 0, j = nums.length - 1; i < j; ) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                for (int k = 0; k < temp.length; k++) {
                    if (ret[0] == -1 && temp[k] == nums[i]) {
                        ret[0] = k;
                    } else if (ret[1] == -1 && temp[k] == nums[j]) {
                        ret[1] = k;
                    }
                }
                return ret;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println("twoSum(new int[]{3,2,4},6) = " + Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, -2, -3, -4, -5}, -8)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 22)));
    }
}
