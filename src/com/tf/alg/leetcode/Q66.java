package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-09-17
 */
public class Q66 {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int j = len - 1; j >= 0; j--) {
            if (digits[j] != 9) {
                digits[j]++;
                return digits;
            }
            digits[j] = 0;
        }

        int[] newDigits = new int[len + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] a = new int[]{};
    }
}