package com.tf.alg.leetcode;

import com.tf.alg.ListNode;

/**
 * Created by tingfang
 * 2018-10-24
 */
public class Q61 {
    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }
        int len = 1;
        ListNode fh = head;
        ListNode temp = head;
        while (head.next != null) {
            head = head.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return fh;
        }
        k = len - k;
        while (--k > 0) {
            temp = temp.next;
        }
        head.next = fh;
        head = temp.next;
        temp.next = null;
        return head;
    }

    private static ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }
        int len = 1;
        ListNode temp = head;
        while (head.next != null) {
            head = head.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return temp;
        }
        head.next = temp;
        k = len - k;
        while (--k > 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        System.out.print("rotateRight(ListNode.create(1,2,3,4,5), 2) = ");
        rotateRight(ListNode.create(1, 2, 3, 4, 5), 2).print();
        System.out.print("rotateRight(ListNode.create(1,2,3,4,5), 6) = ");
        rotateRight(ListNode.create(1, 2, 3, 4, 5), 6).print();

        System.out.print("rotateRight1(ListNode.create(1,2,3,4,5), 2) = ");
        rotateRight1(ListNode.create(1, 2, 3, 4, 5), 2).print();
        System.out.print("rotateRight1(ListNode.create(1,2,3,4,5), 6) = ");
        rotateRight1(ListNode.create(1, 2, 3, 4, 5), 6).print();
    }
}