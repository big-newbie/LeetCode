package com.tf.alg.leetcode;

import com.tf.alg.ListNode;

/**
 * Created by tingfang
 * 2018-09-13
 */
public class Q23 {
    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode[] temp = new ListNode[(lists.length + 1) / 2];
        for (int i = 0, j = 0; i < lists.length; i += 2, j++) {
            if (i + 1 < lists.length) {
                temp[j] = Q21.mergeTwoLists(lists[i], lists[i + 1]);
            } else {
                temp[j] = lists[i];
            }
        }
        return mergeKLists(temp);
    }

    public static void main(String[] args) {
        ListNode[] lists = {
                ListNode.create(0),
                ListNode.create(1, 4, 7),
                ListNode.create(2, 5, 8),
                ListNode.create(3, 6, 9),
                ListNode.create(10)
        };
        mergeKLists(lists).print();
    }
}