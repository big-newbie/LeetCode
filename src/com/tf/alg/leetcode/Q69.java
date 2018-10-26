package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-09-17
 */
public class Q69 {
    private static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        if (x < 4) {
            return 1;
        }
        int t = x / 2;
        while (t > x / t) {
            t--;
        }
        return t;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println("mySqrt(" + i + ") = " + mySqrt(i));
        }
        System.out.println("mySqrt(" + 2147395599 + ") = " + mySqrt(2147395599));
        int i = 1;
        int j = i++;
        System.out.println(j);
    }
}
