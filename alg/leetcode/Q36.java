package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-09-16
 */
public class Q36 {

    public static boolean isValidSudoku1(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] square = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int digit = board[i][j] - '1';
                row[i][digit] += 1;
                if (row[i][digit] > 1) {
                    return false;
                }
                column[j][digit] += 1;
                if (column[j][digit] > 1) {
                    return false;
                }
                int index = (i / 3) * 3 + (j / 3);
                square[index][digit] += 1;
                if (square[index][digit] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidSudoku(char[][] board) {
        return isValidSudoku(transform(board));
    }

    private static boolean isValidSudoku(int[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] cell = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] > -1 && !isValid(row, column, cell, i, j, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int[][] row, int[][] column, int[][] cell, int r, int c, int value) {
        if (row[r][value] >= 1) {
            return false;
        }
        if (column[c][value] >= 1) {
            return false;
        }
        if (cell[(r / 3) * 3 + c / 3][value] >= 1) {
            return false;
        }
        row[r][value]++;
        column[c][value]++;
        cell[(r / 3) * 3 + c / 3][value]++;
        return true;
    }

    public static int[][] transform(char[][] board) {
        int[][] ret = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    ret[i][j] = board[i][j] - '1';
                } else {
                    ret[i][j] = -1;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '3', '.', '.', '5', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '8', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '1', '1', '6', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '1', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '7'},
                {'.', '.', '.', '.', '.', '.', '.', '4', '.'}};
        System.out.println(isValidSudoku(board));
    }
}