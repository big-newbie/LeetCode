package com.tf.alg.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by tingfang
 * 2018-10-29
 */
public class Q162 {
    private static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        int i = 0;
        int j = len - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if ((m == 0 || nums[m] > nums[m - 1]) && (m == len - 1 || nums[m] > nums[m + 1])) {
                return m;
            } else if (m == 0) {
                i = m + 1;
            } else if (m == len - 1) {
                j = m - 1;
            } else if (nums[m] < nums[m - 1]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println("findPeakElement(new int[]{3,4,3,2,1}) = " + findPeakElement(new int[]{3, 4, 3, 2, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        while (true) {
            Random random = new Random();
            int len = random.nextInt(20) + 1;
            Set<Integer> set = new HashSet<>();
            int[] nums = new int[len];
            for (int i = 0; i < len; ) {
                int anInt = random.nextInt(100);
                if (set.add(anInt)) {
                    nums[i++] = anInt;
                }
            }
            int peakElement = findPeakElement(nums);
//            if (!((peakElement == 0 || nums[peakElement] > nums[peakElement - 1]) && (peakElement == len - 1 || nums[peakElement] > nums[peakElement + 1]))) {
            System.out.println(Arrays.toString(nums));
            System.out.println(peakElement);
//                System.out.println();
//            }
        }
    }
}
