package com.tf.alg.leetcode;

import com.tf.alg.ListNode;

/**
 * Created by tingfang
 * 2018-12-06
 */
public class Q2 {

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode ret = new ListNode(-1);
        ListNode temp = ret;
        int carry = 0;
        while (l1 != null && l2 != null) {
            ListNode t = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            temp.next = t;
            temp = t;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null && carry == 1) {
            ListNode t = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            temp.next = t;
            temp = t;
            l1 = l1.next;
        }
        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = new ListNode(1);
        }
        while (l2 != null && carry == 1) {
            ListNode t = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            temp.next = t;
            temp = t;
            l2 = l2.next;
        }
        if (l2 != null) {
            temp.next = l2;
        } else {
            temp.next = new ListNode(1);
        }
        return ret.next;
    }

    public static void main(String[] args) {
        addTwoNumbers(ListNode.create(2, 4, 3), ListNode.create(5, 6, 4)).print();
        addTwoNumbers(ListNode.create(1), ListNode.create(9, 9, 9, 9)).print();
        addTwoNumbers(ListNode.create(8, 8, 8), ListNode.create(8, 8, 8)).print();
    }
}