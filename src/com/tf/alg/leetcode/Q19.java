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
        ListNode.Builder.newBuilder().next(1).next(2).next(3).next(4).next(5).build().print();
        removeNthFromEnd(ListNode.Builder.newBuilder().next(1).next(2).next(3).next(4).next(5).build(), 1).print();
        removeNthFromEnd(ListNode.Builder.newBuilder().next(1).next(2).next(3).next(4).next(5).build(), 2).print();
        removeNthFromEnd(ListNode.Builder.newBuilder().next(1).next(2).next(3).next(4).next(5).build(), 3).print();
        removeNthFromEnd(ListNode.Builder.newBuilder().next(1).next(2).next(3).next(4).next(5).build(), 4).print();
        removeNthFromEnd(ListNode.Builder.newBuilder().next(1).next(2).next(3).next(4).next(5).build(), 5).print();
    }
}