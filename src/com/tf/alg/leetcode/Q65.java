package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-11-05
 */
public class Q65 {//TODO 未通过.......
    private static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return false;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c < '0' || c > '9') {
                if (len == 1) {
                    return false;
                }
                if (c == 'e' || c == 'E') {
                    return i > 0 && chars[i - 1] <= '9' && chars[i - 1] >= '0' && i + 1 != len && isInteger(chars, (chars[i + 1] == '+' || chars[i + 1] == '-') ? i + 2 : i + 1, len - 1);
                } else if ((c == '+' || c == '-')) {
                    if (i != 0 || i + 1 == len || chars[i + 1] > '9' || chars[i + 1] < '0') {
                        return false;
                    }
                } else if (c == '.') {
                    if (i + 1 == len) {
                        return true;
                    } else if (chars[i + 1] > '9' || chars[i + 1] < '0') {
                        return false;
                    } else {
                        for (i++; i < len; i++) {
                            c = chars[i];
                            if (c < '0' || c > '9') {
                                return ((c == 'e') || (c == 'E')) && ((i + 1) != len) && isInteger(chars, (chars[i + 1] == '+' || chars[i + 1] == '-') ? i + 2 : i + 1, len - 1);
                            }
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isInteger(char[] chars, int i, int j) {
        if (i > j) {
            return false;
        }
        if (i == j) {
            return chars[i] <= '9' && chars[i] >= '0';
        }
        for (; i <= j; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
////        System.out.println("isNumber(\"0\") = " + isNumber("0"));
////        System.out.println("isNumber(\"  0.1  \") = " + isNumber("  0.1  "));
////        System.out.println("isNumber(\" 0.1e2\") = " + isNumber(" 0.1e2"));
////        System.out.println("isNumber(\"asdf\") = " + isNumber("asdf"));
////        System.out.println("isNumber(\"+12e+1\") = " + isNumber("+12e+1"));
////        System.out.println("isNumber(\"-1e-1e1\") = " + isNumber("-1e-1e1"));
////        System.out.println("isNumber(\".1\") = " + isNumber(".1"));
////        System.out.println("isNumber(\"2e2\") = " + isNumber("2e2"));
////        System.out.println("isNumber(\"12e\") = " + isNumber("12e"));
////        System.out.println("isNumber(\"12.\") = " + isNumber("12."));
////        System.out.println("isNumber(\"12e.2\") = " + isNumber("12e.2"));
//        System.out.println("isNumber(\"e3\") = " + isNumber("e9"));
        System.out.println(Double.parseDouble("    .1 "));
        System.out.println(Double.parseDouble("     +.8"));
    }
}