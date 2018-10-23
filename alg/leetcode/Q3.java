package com.tf.alg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tingfang
 * 2018-08-11
 */
public class Q3 {
    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int cur = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer prev = map.put(c, i);
            if (prev == null || prev < start) {
                if (++cur > maxLen) {
                    maxLen = cur;
                }
            } else {
                start = prev + 1;
                cur = i - prev;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwkevmvvvabcd"));
        System.out.println(lengthOfLongestSubstring("tmmzuxttmmzuxtvt"));
    }
}
