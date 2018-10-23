package com.tf.alg.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tingfang
 * 2018-09-16
 */
public class Q52 {
    private static int totalNQueens(int n) {
        if (n < 4) {
            if (n == 1) {
                return 1;
            }
            return 0;
        }
        long s = System.currentTimeMillis();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int[] pos = new int[n];
        bt(atomicInteger, pos, 0);
        System.out.println("N Queen " + n + " time : " + (System.currentTimeMillis() - s));
        return atomicInteger.get();
    }

    private static void bt(AtomicInteger atomicInteger, int[] pos, int cur) {
        if (cur >= pos.length) {
            atomicInteger.incrementAndGet();
            return;
        }
        for (int i = 0; i < pos.length; i++) {
            if (isValid(pos, cur, i)) {
                pos[cur] = i;
                bt(atomicInteger, pos, cur + 1);
            }
        }
    }

    private static boolean isValid(int[] pos, int row, int value) {
        for (int i = row - 1; i >= 0; i--) {
            if (pos[i] == value || Math.abs(pos[i] - value) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("totalNQueens(" + i + ") = " + totalNQueens(i));
            System.out.println();
        }
    }
}
