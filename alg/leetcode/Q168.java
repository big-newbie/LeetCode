package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-09-19
 */
public class Q168 {
    private static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        if (n < 1) {
            return sb.toString();
        }
        while (n > 0) {
            int a = (n - 1) % 26;
            n = (n - 1) / 26;
            sb.append((char) (a + 'A'));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
    }
}