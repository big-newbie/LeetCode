package com.tf.alg.leetcode;

import com.tf.alg.TreeLinkNode;

/**
 * Created by tingfang
 * 2018-10-30
 */
public class Q116 {
    private static void connect(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        TreeLinkNode cur = root;
        TreeLinkNode next = null;
        TreeLinkNode nextHead = root.left;
        while (cur.left != null) {
            cur.left.next = cur.right;
            if (next != null) {
                cur.right.next = next.left;
                cur = next;
                next = next.next;
            } else {
                cur = nextHead;
                next = cur.next;
                nextHead = cur.left;
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        TreeLinkNode t6 = new TreeLinkNode(6);
        TreeLinkNode t7 = new TreeLinkNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        connect(t1);
        System.out.println(t1);
    }
}
