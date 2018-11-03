package com.tf.alg.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by tingfang
 * 2018-11-03
 */
public class Q150 {
    private static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new IllegalArgumentException();
        }
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int t = stack.pop();
                    stack.push(stack.pop() / t);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
}