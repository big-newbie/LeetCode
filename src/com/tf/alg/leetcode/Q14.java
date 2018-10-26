package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-08-14
 */
public class Q14 {
    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int i = 0;
        boolean flag = true;
        while (flag) {
            char t;
            if (strs[0] == null || strs[0].length() <= i) {
                break;
            }
            t = strs[0].charAt(i);
            for (int j = 1; flag && j < strs.length; j++) {
                if (strs[j] == null || strs[j].length() <= i || strs[j].charAt(i) != t) {
                    flag = false;
                }
            }
            if (flag) {
                i++;
            }
        }
        return strs[0] == null ? "" : strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{}));
    }
}