package com.tf.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-08-14
 */
public class Q17 {
    static final char[][] chars = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    private static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ret;
        }
        List<StringBuilder> list = fullPermutation(digits);
        for (StringBuilder s : list) {
            ret.add(s.toString());
        }
        return ret;
    }

    private static List<StringBuilder> fullPermutation(String str) {
        List<StringBuilder> list = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            int idx = str.charAt(index) - '2';
            if (idx >= chars.length || idx < 0) {
                throw new RuntimeException();
            }
            char[] _chars = chars[idx];
            if (list.isEmpty()) {
                for (char c : _chars) {
                    list.add(new StringBuilder().append(c));
                }
            } else {
                List<StringBuilder> temp = new ArrayList<>(list);
                list.clear();
                for (StringBuilder sb : temp) {
                    for (char c : _chars) {
                        list.add(new StringBuilder(sb).append(c));
                    }
                }
            }
            index++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-8));
        System.out.println(Integer.toBinaryString(-9));
        System.out.println(letterCombinations("23"));
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(8));
    }
}