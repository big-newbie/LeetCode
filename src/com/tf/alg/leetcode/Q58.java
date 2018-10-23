package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-09-13
 */
public class Q58 {
    private static int lengthOfLastWord(String s) {
        int ret = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (ret > 0) {
                    return ret;
                }
            } else {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello world"));
        System.out.println(lengthOfLastWord("asdf"));
        System.out.println(lengthOfLastWord("asd asdf  "));
    }
}