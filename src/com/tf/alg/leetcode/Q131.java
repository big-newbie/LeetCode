package com.tf.alg.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-11-06
 */
public class Q131 {
    private static List<List<String>> partition(String s) {
        List<List<String>> lists = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return lists;
        }
        LinkedList<Integer> indexes = new LinkedList<>();
        bt(lists, s.toCharArray(), 0, indexes);
        return lists;
    }

    private static void bt(List<List<String>> lists, char[] chars, int i, List<Integer> indexes) {
        if (i == chars.length) {
            int prev = 0;
            List<String> list = new LinkedList<>();
            for (Integer index : indexes) {
                list.add(new String(chars, prev, index - prev + 1));
                prev = index + 1;
            }
            lists.add(list);
            return;
        }
        for (int j = i; j < chars.length; j++) {
            if (isPalindrome(chars, i, j)) {
                indexes.add(j);
                bt(lists, chars, j + 1, indexes);
                indexes.remove(indexes.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(char[] chars, int i, int j) {
        for (; i < j && chars[i] == chars[j]; i++, j--) {}
        return i >= j;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("partition"));
        System.out.println(partition("boolean"));
    }
}
