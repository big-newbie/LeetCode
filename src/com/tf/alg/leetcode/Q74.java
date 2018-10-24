package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-24
 */
public class Q74 {

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int r = matrix.length - 1;
        int c = 0;
        while (r >= 0 && c < matrix[0].length) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                r--;
            } else {
                c++;
            }
        }
        return false;
    }

    private static boolean searchMatrix1(int[][] matrix, int target) {
        return s(matrix, 0, matrix.length - 1, 0, matrix[0].length, target);
    }

    private static boolean s(int[][] matrix, int xl, int xh, int yl, int yh, int target) {
        // TODO "四分法" 比较复杂，有空实现。。。
        return false;
    }
}