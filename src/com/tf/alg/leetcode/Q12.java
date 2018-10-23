package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-23
 */
public class Q12 {
    private static final int[] keys = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] vals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num - keys[i] >= 0) {
                num -= keys[i];
                sb.append(vals[i]);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("intToRoman(3) = " + intToRoman(3));
        System.out.println("intToRoman(58) = " + intToRoman(58));
        System.out.println("intToRoman(1994) = " + intToRoman(1994));
        System.out.println("intToRoman(3905) = " + intToRoman(3905));
    }
}
