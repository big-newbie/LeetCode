package com.tf.alg.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by tingfang
 * 2018-08-14
 */
public class Q20 {
    private static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if ((s.length() & 1) != 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == ')' || c == ']' || c == '}') {
                char pop = stack.pop();
                if ((pop == '(' && c != ')') || (pop == '{' && c != '}') || (pop == '[' && c != ']')) {
                    return false;
                }
            } else {
                throw new RuntimeException("illegal input");
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("isValid(\"\") = " + isValid(""));
        System.out.println("isValid(\"((())){}\") = " + isValid("((())){}"));
        System.out.println("isValid(\"({)}\")) = " + isValid("({)}"));
    }
}
