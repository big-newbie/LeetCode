package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-08-15
 */
public class Q70 {
    private static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int c = 1;
        int p = 0;
        while (n-- > 0) {
            c += p;
            p = c - p;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
