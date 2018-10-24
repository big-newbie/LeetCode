package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-24
 */
public class Q73 {
    /**
     * O(m + n) space
     */
    private static void setZeros(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int[] flag = new int[r + c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    flag[i] = -1;
                    flag[r + j] = -1;
                }
            }
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == -1) {
                if (i < r) {
                    for (int j = 0; j < c; j++) {
                        matrix[i][j] = 0;
                    }
                } else {
                    for (int j = 0; j < r; j++) {
                        matrix[j][i - r] = 0;
                    }
                }
            }
        }
    }
}