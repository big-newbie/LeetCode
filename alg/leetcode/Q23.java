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
                ListNode.builder().next(0).build(),
                ListNode.builder().next(1, 4, 7).build(),
                ListNode.builder().next(2, 5, 8).build(),
                ListNode.builder().next(3, 6, 9).build(),
                ListNode.builder().next(10).build()
        };
        mergeKLists(lists).print();
    }
}