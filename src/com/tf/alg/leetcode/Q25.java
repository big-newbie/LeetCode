package com.tf.alg.leetcode;

import com.tf.alg.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by tingfang
 * 2018-09-16
 */
public class Q25 {

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        Deque<ListNode> stack = new LinkedList<>();
        ListNode fh = new ListNode(0);
        fh.next = head;
        ListNode prev = fh;
        while (head != null) {
            int i = 0;
            while (i < k && head != null) {
                stack.push(head);
                head = head.next;
                i++;
            }
            if (i == k) {
                while (!stack.isEmpty()) {
                    prev.next = stack.pop();
                    prev = prev.next;
                }
                prev.next = head;
            }
        }
        return fh.next;
    }

    public static void main(String[] args) {
        reverseKGroup(ListNode.create(1, 2, 3, 4, 5, 6, 7), 8).print();
    }
}