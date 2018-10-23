package com.tf.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-09-16
 */
public class Q51 {

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        if (n < 4) {
            if (n == 1) {
                List<String> list = new ArrayList<>();
                list.add("Q");
                lists.add(list);
            }
            return lists;
        }
        int[] pos = new int[n];
        char[] chars = new char[n];
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '.';
        }
        for (int i = 0; i < n; i++) {
            chars[i] = 'Q';
            strings[i] = new String(chars);
            chars[i] = '.';
        }
        bt(lists, pos, 0, strings);
        return lists;
    }

    private static void bt(List<List<String>> lists, int[] pos, int cur, String[] strings) {
        if (cur >= pos.length) {
            List<String> list = new ArrayList<>(cur);
            for (int po : pos) {
                list.add(strings[po]);
            }
            lists.add(list);
            return;
        }
        for (int i = 0; i < pos.length; i++) {
            if (isValid(pos, cur, i)) {
                pos[cur] = i;
                bt(lists, pos, cur + 1, strings);
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
//        System.out.println(solveNQueens(14).size());
        System.out.println(solveNQueens(1));

    }
}