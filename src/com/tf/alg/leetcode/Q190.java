package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-27
 */
public class Q190 {
    private static int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret = (ret << 1) | (n & 1);
            n = n >> 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
