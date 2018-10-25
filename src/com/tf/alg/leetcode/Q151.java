package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-25
 */
public class Q151 {
    private static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start <= end && chars[start] == ' ') {
            start++;
        }
        while (end >= start && chars[end] == ' ') {
            end--;
        }
        if (start > end) {
            return "";
        }
        if (start == end) {
            return new String(chars, start, 1);
        }
        r(chars, start, end);
        int p = -1;
        int l = -1;
        for (int i = start; i <= end; i++) {
            if (p != -1 && l != -1) {
                r(chars, p, l);
                p = l = -1;
            }
            if (p == -1 && chars[i] != ' ') {
                p = i;
            }
            if (p != -1 && chars[i] == ' ') {
                l = i - 1;
            }
        }
        r(chars, p, end);
        char[] word = new char[end - start + 1];
        int index = 0;
        for (; start <= end; start++) {
            if (chars[start] != ' ' || (index > 0 && word[index - 1] != ' ')) {
                word[index++] = chars[start];
            }
        }
        return new String(word, 0, index);
    }

    private static void r(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        reverseWords("a");
    }
}