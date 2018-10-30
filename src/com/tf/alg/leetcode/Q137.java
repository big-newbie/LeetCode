package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-31
 */
public class Q137 {
    private static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] mask = new int[32];
        int[] bitCount = new int[32];
        for (int i = 0; i < 32; i++) {
            mask[i] = 1 << (31 - i);
        }
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                if ((n & mask[i]) != 0) {
                    bitCount[i]++;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % 3 != 0) {
                ret = (ret | mask[i]);
            }
        }
        return ret;
    }
}
