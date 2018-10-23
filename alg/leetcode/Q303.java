package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-08-15
 */
public class Q303 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
//        NumArray na = new NumArray(nums);
        NumArray1 na = new NumArray1(nums);
        System.out.println(na.sumRange(0, 2));
        System.out.println(na.sumRange(2, 5));
        System.out.println(na.sumRange(0, 5));
        System.out.println(na.sumRange(0, 0));
//        System.out.println(Arrays.toString(na.dp));
    }

    static class NumArray1 {
        private final int[] sum;
        private final int len;

        public NumArray1(int[] nums) {
            if (nums == null || nums.length == 0) {
                this.sum = new int[0];
                this.len = 0;
            } else {
                this.len = nums.length;
                this.sum = new int[len];
                sum[0] = nums[0];
                for (int i = 1; i < len; i++) {
                    sum[i] = sum[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? sum[j] : sum[j] - sum[i - 1];
        }
    }

    static class NumArray {
        private final int[] dp;
        private final int len;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                dp = new int[0];
                len = 0;
            } else {
                len = nums.length;
                dp = new int[(len + 1) * len / 2];
                for (int i = 0; i < len; i++) {
                    for (int j = i; j < len; j++) {
                        if (i == j) {
                            dp[index(i, j)] = nums[i];
                        } else {
                            dp[index(i, j)] = dp[index(i, j - 1)] + nums[j];
                        }
                    }
                }
            }
        }

        public int sumRange(int i, int j) {
            return dp[index(i, j)];
        }

        private int index(int i, int j) {
            return (2 * len - i + 1) * i / 2 + j - i;
        }
    }
}