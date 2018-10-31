package com.tf.alg.leetcode;

import com.tf.alg.TreeLinkNode;

/**
 * Created by tingfang
 * 2018-10-31
 */
public class Q117 {
    private static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode cur = root;
        TreeLinkNode nextHead = null;
        TreeLinkNode nextPrev = null;
        while (cur != null) {
            if (cur.left != null) {
                if (nextHead == null) {
                    nextHead = cur.left;
                    nextPrev = nextHead;
                } else {
                    nextPrev.next = cur.left;
                    nextPrev = cur.left;
                }
            }
            if (cur.right != null) {
                if (nextHead == null) {
                    nextHead = cur.right;
                    nextPrev = nextHead;
                } else {
                    nextPrev.next = cur.right;
                    nextPrev = cur.right;
                }
            }
            if (cur.next != null) {
                cur = cur.next;
            } else {
                cur = nextHead;
                nextHead = null;
            }
        }
    }
}