package com.tf.alg.leetcode;

import com.tf.alg.ListNode;

/**
 * Created by tingfang
 * 2018-11-01
 */
public class Q142 {
    private static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        while (a != null && a.next != null) {
            b = b.next;
            a = a.next.next;
            if (a == b) {
                a = head;
                while (a != b) {
                    a = a.next;
                    b = b.next;
                }
                return a;
            }
        }
        return null;
    }
}
