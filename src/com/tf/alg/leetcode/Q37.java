package com.tf.alg.leetcode;

import java.util.Arrays;

/**
 * Created by tingfang
 * 2018-09-16
 */
public class Q37 {
    private static void solveSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][] cell = new int[9][9];
        int[][] intBoard = new int[9][9];
        transform(board, intBoard, row, column, cell);
        solveSudoku(board, intBoard, row, column, cell, 0, 0);
    }

    private static void transform(char[][] board, int[][] intBoard, int[][] row, int[][] column, int[][] cell) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - '1';
                    intBoard[i][j] = value;
                    row[i][value]++;
                    column[j][value]++;
                    cell[(i / 3) * 3 + j / 3][value]++;
                } else {
                    intBoard[i][j] = -1;
                }
            }
        }
    }

    private static void transform(int[][] intBoard, char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = (char) (intBoard[i][j] + '1');
            }
        }
    }

    private static void solveSudoku(char[][] origin, int[][] board, int[][] row, int[][] column, int[][] cell, int i, int j) {
        if (i > 8) {
            transform(board, origin);
            return;
        }
        if (board[i][j] == -1) {
            for (int k = 0; k < 9; k++) {
                if (row[i][k] == 0 && column[j][k] == 0 && cell[(i / 3) * 3 + j / 3][k] == 0) {
                    board[i][j] = k;
                    row[i][k]++;
                    column[j][k]++;
                    cell[(i / 3) * 3 + j / 3][k]++;
                    if (j < 8) {
                        solveSudoku(origin, board, row, column, cell, i, j + 1);
                    } else {
                        solveSudoku(origin, board, row, column, cell, i + 1, 0);
                    }
                    board[i][j] = -1;
                    row[i][k]--;
                    column[j][k]--;
                    cell[(i / 3) * 3 + j / 3][k]--;
                }
            }
        } else if (j < 8) {
            solveSudoku(origin, board, row, column, cell, i, j + 1);
        } else {
            solveSudoku(origin, board, row, column, cell, i + 1, 0);
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}