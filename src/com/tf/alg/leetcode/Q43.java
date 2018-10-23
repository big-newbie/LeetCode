package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-23
 */
public class Q43 {

    private static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        int i = 0;
        int la = num1.length();
        int lb = num2.length();
        String ret = "0";
        while (i < lb) {
            int cur = num2.charAt(lb - i - 1) - '0';
            int[] chars = new int[la];
            int carry = 0;
            for (int j = 0; j < la; j++) {
                int p = (num1.charAt(la - j - 1) - '0') * cur + carry;
                carry = 0;
                if (p >= 10) {
                    carry = p / 10;
                    p = p % 10;
                }
                chars[chars.length - j - 1] = p;
            }
            StringBuilder sb = new StringBuilder();
            if (carry > 0) {
                sb.append(carry);
            }
            for (int aChar : chars) {
                sb.append(aChar);
            }
            for (int j = 0; j < i; j++) {
                sb.append('0');
            }
            ret = add(ret, sb.toString());
            i++;
        }
        return ret;
    }

    private static String add(String a, String b) {
        int[] chars = new int[Math.max(a.length(), b.length())];
        int offset = 1;
        int carry = 0;
        while (offset <= a.length() && offset <= b.length()) {
            int sum = digit(a, offset) + digit(b, offset) + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            }
            chars[chars.length - offset] = sum;
            offset++;
        }
        while (offset <= a.length()) {
            int sum = digit(a, offset) + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            }
            chars[chars.length - offset] = sum;
            offset++;
        }
        while (offset <= b.length()) {
            int sum = digit(b, offset) + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            }
            chars[chars.length - offset] = sum;
            offset++;
        }
        StringBuilder sb = new StringBuilder(chars.length);
        if (carry == 1) {
            sb.append('1');
        }
        for (int aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }

    private static int digit(String s, int offset) {
        return s.charAt(s.length() - offset) - '0';
    }

    public static void main(String[] args) {
        System.out.println(add("999", "11"));
        System.out.println("multiply(\"8\", \"8\") = " + multiply("8", "8"));
        System.out.println("multiply(\"5\",\"20\") = " + multiply("5", "20"));
        System.out.println("multiply(\"123456789\",\"9876543215\") = " + multiply("123456789", "9876543215"));
        System.out.println("multiply(\"123\",\"987\") = " + multiply("123", "987"));
    }
}