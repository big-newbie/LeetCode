package com.tf.alg.leetcode;

import com.tf.alg.ListNode;

/**
 * Created by tingfang
 * 2018-10-24
 */
public class Q82 {

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fh = new ListNode(-1);
        ListNode prev = fh;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                int temp = head.val;
                while (head != null && head.val == temp) {
                    head = head.next;
                }
            } else {
                prev.next = head;
                prev = head;
                head = head.next;
                prev.next = null;
            }
        }
        return fh.next;
    }

    public static void main(String[] args) {
        deleteDuplicates(ListNode.create(1, 1, 2, 2, 3, 3, 4, 4, 5)).print();
    }
}
