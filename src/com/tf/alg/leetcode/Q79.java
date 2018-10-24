package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-24
 */
public class Q79 {
    private static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null) {
            return true;
        }
        boolean[][] used = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(used, board, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 战胜98.71%，实现有些繁琐了，另外 used 貌似可以省略？？
     */
    private static boolean exist(boolean[][] used, char[][] board, int i, int j, char[] word, int index) {
        if (board[i][j] == word[index]) {
            if (index == word.length - 1) {
                return true;
            }
            index++;
            used[i][j] = true;
            if (i < board.length - 1) {//上
                if (!used[i + 1][j] && board[i + 1][j] == word[index] && exist(used, board, i + 1, j, word, index)) {
                    return true;
                }
            }
            if (i > 0) {//下
                if (!used[i - 1][j] && board[i - 1][j] == word[index] && exist(used, board, i - 1, j, word, index)) {
                    return true;
                }
            }
            if (j < board[0].length - 1) {//右
                if (!used[i][j + 1] && board[i][j + 1] == word[index] && exist(used, board, i, j + 1, word, index)) {
                    return true;
                }
            }
            if (j > 0) {//左
                if (!used[i][j - 1] && board[i][j - 1] == word[index] && exist(used, board, i, j - 1, word, index)) {
                    return true;
                }
            }
            used[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println("exist() = " + exist(board, "ABCCED"));
        System.out.println("exist() = " + exist(board, "SEE"));
        System.out.println("exist() = " + exist(board, "ABCB"));
        System.out.println(exist(new char[][]{{'a'}}, "b"));
    }
}