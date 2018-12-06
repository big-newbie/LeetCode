package com.tf.alg.leetcode;

import com.tf.alg.ListNode;

/**
 * Created by tingfang
 * 2018-09-13
 */
public class Q21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fh = new ListNode(0);
        ListNode cur = fh;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return fh.next;
    }

    public static void main(String[] args) {
        ListNode merged = mergeTwoLists(ListNode.create(1, 2, 3, 4, 5), ListNode.create(1, 2, 3, 4, 5, 6, 7));
        merged.print();
    }
}