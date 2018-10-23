package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-09-19
 */
public class Q13 {
    private static int romanToInt(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                ret += 1000;
            } else if (c == 'D') {
                ret += 500;
            } else if (c == 'C') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'D') {
                        ret += 300;
                        i++;
                    } else if (s.charAt(i + 1) == 'M') {
                        ret += 800;
                        i++;
                    }
                }
                ret += 100;
            } else if (c == 'L') {
                ret += 50;
            } else if (c == 'X') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'L') {
                        ret += 30;
                        i++;
                    } else if (s.charAt(i + 1) == 'C') {
                        ret += 80;
                        i++;
                    }
                }
                ret += 10;
            } else if (c == 'V') {
                ret += 5;
            } else if (c == 'I') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'V') {
                        ret += 3;
                        i++;
                    } else if (s.charAt(i + 1) == 'X') {
                        ret += 8;
                        i++;
                    }
                }
                ret += 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
