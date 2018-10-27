package com.tf.alg.leetcode;

import java.util.Random;

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
        int j = x;
        int i = 0;
        while (i + 1 < j) {
            int m = j - (j - i) / 2;
            int p = x / m;
            if (p == m) {
                return m;
            } else if (p < m) {
                j = m;
            } else {
                i = m;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        while (true) {
            int random = new Random().nextInt(Integer.MAX_VALUE);
            int sqrt = mySqrt(random);
            double sqrt1 = Math.sqrt(random);
            if (sqrt != (int) sqrt1) {
                System.out.println(random);
            }
        }
    }
}