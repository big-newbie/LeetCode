package com.tf.alg.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by tingfang
 * 2018-09-20
 */
public class Q155 {
    static class MinStack {
        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (min.peek() != null && min.peek() < x) {
                min.push(min.peek());
            } else {
                min.push(x);
            }
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.top();
//        System.out.println(minStack.getMin());
    }
}
