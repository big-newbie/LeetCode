package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-08-13
 */
public class Q5 {
    static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int ol = 1, os = 0, el = 0, es = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean oi = true, ei = true;
            for (int j = 1; (oi || ei) && i + j < s.length() && i - j + 1 >= 0; j++) {
                oi = oi && i - j >= 0 && s.charAt(i - j) == s.charAt(i + j);
                if (oi && 2 * j + 1 > ol) {
                    ol = 2 * j + 1;
                    os = i - j;
                }
                ei = ei && s.charAt(i - j + 1) == s.charAt(i + j);
                if (ei && 2 * j > el) {
                    el = 2 * j;
                    es = i - j + 1;
                }
            }
        }
        return s.substring(ol > el ? os : es, (ol > el ? (ol + os) : (el + es)));
    }

    public static void main(String[] args) {
        System.out.println("longestPalindrome(\"babad\") = " + longestPalindrome("babad"));
        System.out.println("longestPalindrome(\"cbddbcb\") = " + longestPalindrome("cbddbcb"));
        System.out.println("longestPalindrome(\"cbddbcbdd\") = " + longestPalindrome("cbddbcbdd"));
        System.out.println("longestPalindrome(\"ab\") = " + longestPalindrome("ab"));
        System.out.println("longestPalindrome(\"abcda\") = " + longestPalindrome("abcda"));
    }
}
