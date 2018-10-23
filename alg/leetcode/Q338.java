package com.tf.alg.leetcode;

import java.util.Arrays;

import static java.lang.Integer.toBinaryString;

/**
 * Created by tingfang
 * 2018-08-16
 */
public class Q338 {
    private static int[] countBits2(int num) {
        if (num < 0) {
            return new int[0];
        }
        if (num == 0) {
            return new int[1];
        }
        int prev = 1;
        int next = 2;
        int[] ret = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (i == next) {
                prev = next;
                next *= 2;
            }
            ret[i] = ret[i - prev] + 1;
        }
        return ret;
    }

    private static int[] countBits1(int num) {
        if (num < 0) {
            return new int[0];
        }
        if (num == 0) {
            return new int[1];
        }
        int[] ret = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 0) {
                ret[i] = ret[i >> 1];
            } else {
                ret[i] = ret[i - 1] + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits1(5)));
        System.out.println(Arrays.toString(countBits2((16))));

        System.out.println(toBinaryString(3));
        System.out.println(toBinaryString(3 >> 1));
        System.out.println(toBinaryString(5));
        System.out.println(toBinaryString(5 >> 1));
        System.out.println(toBinaryString(7));
        System.out.println(toBinaryString(7 >> 1));
        System.out.println(toBinaryString(9));
        System.out.println(toBinaryString(9 >> 1));
    }
}