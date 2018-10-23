package com.tf.alg.leetcode;

import com.tf.alg.ListNode;

/**
 * Created by tingfang
 * 2018-09-16
 */
public class Q24 {
    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fh = new ListNode(0);
        fh.next = head;
        ListNode prev = fh;
        while (head != null && head.next != null) {
            prev.next = head.next;
            head.next = head.next.next;
            prev.next.next = head;
            prev = head;
            head = head.next;
        }
        return fh.next;
    }
}