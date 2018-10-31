package com.tf.alg.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tingfang
 * 2018-10-31
 */
public class Q166 {
    private static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(numerator / denominator);
        int remainder = numerator % denominator;
        if (remainder == 0) {
            return sb.toString();
        }
        StringBuilder fraction = new StringBuilder();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int i = 0;
        while (!map.containsKey(remainder)) {
            map.put(remainder, i++);
            remainder *= 10;
            fraction.append(remainder / denominator);
            remainder = remainder % denominator;
        }
        sb.append(".");
        if (remainder == 0) {
            sb.append(fraction);
        } else {
            if (map.get(remainder) != 0) {
                sb.append(fraction.substring(0, map.get(remainder)));
            }
            sb.append("(");
            sb.append(fraction.substring(map.get(remainder), fraction.length()));
            sb.append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(16, 166));
//        for (int i = 0; i < 100; i++) {
//            int numerator = new Random().nextInt(1000);
//            int denominator = new Random().nextInt(1000) + 1;
//            System.out.println("numerator = " + numerator);
//            System.out.println("denominator = " + denominator);
//            System.out.println(fractionToDecimal(numerator, denominator));
//            System.out.println(numerator / denominator);
//            System.out.println();
//        }
    }
}
