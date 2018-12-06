package com.tf.alg.leetcode;

import com.tf.alg.ListNode;

/**
 * Created by tingfang
 * 2018-09-13
 */
public class Q19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fh = new ListNode(-1);
        fh.next = head;
        ListNode temp = fh;
        while (n-- >= 0) {
            temp = temp.next;
        }
        head = fh;
        while (temp != null) {
            temp = temp.next;
            head = head.next;
        }
        head.next = head.next.next;
        return fh.next;
    }

    public static void main(String[] args) {
        ListNode.create(1, 2, 3, 4, 5);
        removeNthFromEnd(ListNode.create(1, 2, 3, 4, 5), 1).print();
        removeNthFromEnd(ListNode.create(1, 2, 3, 4, 5), 2).print();
        removeNthFromEnd(ListNode.create(1, 2, 3, 4, 5), 3).print();
        removeNthFromEnd(ListNode.create(1, 2, 3, 4, 5), 4).print();
        removeNthFromEnd(ListNode.create(1, 2, 3, 4, 5), 5).print();
    }
}