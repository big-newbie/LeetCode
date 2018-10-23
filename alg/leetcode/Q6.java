package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-08-11
 */
public class Q6 {
    private static String convert(String s, int numRows) {
        if (numRows < 1) {
            throw new RuntimeException();
        }
        if (s == null || s.length() <= numRows || numRows == 1) {
            return s;
        }
        int t = 2 * numRows - 2;
        char[] chars = new char[s.length()];
        int cur = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += t) {
                chars[cur++] = s.charAt(i + j);
                if (i != 0 && i != numRows - 1 && i + j + 2 * (numRows - 1 - i) < s.length()) {
                    chars[cur++] = s.charAt(i + j + 2 * (numRows - 1 - i));
                }
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
