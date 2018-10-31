package com.tf.alg.leetcode;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by tingfang
 * 2018-10-31
 */
public class Q166 {
    private static String fractionToDecimal(int numerator, int denominator) {
        return fractionToDecimal1(numerator, denominator);
    }

    private static String fractionToDecimal1(long numerator, long denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (numerator < 0 && denominator < 0) {
            return fractionToDecimal1(-numerator, -denominator);
        }
        if (numerator < 0 || denominator < 0) {
            return "-" + fractionToDecimal1(-numerator, denominator);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(numerator / denominator);
        long remainder = (numerator % denominator);
        if (remainder == 0) {
            return sb.toString();
        }
        StringBuilder fraction = new StringBuilder();
        Map<Long, Integer> map = new LinkedHashMap<>();
        int i = 0;
        while (!map.containsKey(remainder) && remainder != 0) {
            map.put(remainder, i++);
            remainder *= 10;
            fraction.append(remainder / denominator);
            remainder = (remainder % denominator);
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
        for (int i = 0; i < 100; i++) {
            int numerator = new Random().nextInt(100);
            int denominator = new Random().nextInt(100) + 1;
            System.out.println("numerator = " + numerator);
            System.out.println("denominator = " + denominator);
            System.out.println(fractionToDecimal(numerator, denominator));
            System.out.println(BigDecimal.valueOf(numerator).divide(BigDecimal.valueOf(denominator), 100, BigDecimal.ROUND_DOWN));
            System.out.println();
        }
    }
}
