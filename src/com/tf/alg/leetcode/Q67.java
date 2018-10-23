package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-09-17
 */
public class Q67 {
    private static String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        boolean carry = false;
        char[] chars = new char[Math.max(a.length(), b.length())];
        int i = 0;
        while (i < a.length() && i < b.length()) {
            if (a.charAt(a.length() - i - 1) != b.charAt(b.length() - i - 1)) {
                chars[chars.length - i - 1] = carry ? '0' : '1';
            } else {
                chars[chars.length - i - 1] = carry ? '1' : '0';
                carry = a.charAt(a.length() - i - 1) == '1';
            }
            i++;
        }
        while (i < a.length()) {
            if (a.charAt(a.length() - i - 1) == '1') {
                chars[chars.length - i - 1] = carry ? '0' : '1';
            } else {
                chars[chars.length - i - 1] = carry ? '1' : '0';
                carry = false;
            }
            i++;
        }
        while (i < b.length()) {
            if (b.charAt(b.length() - i - 1) == '1') {
                chars[chars.length - i - 1] = carry ? '0' : '1';
            } else {
                chars[chars.length - i - 1] = carry ? '1' : '0';
                carry = false;
            }
            i++;
        }
        String ret = new String(chars);
        if (carry) {
            ret = "1" + ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1", "1"));
    }
}