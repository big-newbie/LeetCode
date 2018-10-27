package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

/**
 * Created by tingfang
 * 2018-10-27
 */
public class Q110 {

    private static boolean isBalanced(TreeNode root) {
        return root == null || v(root, new int[1]);
    }

    private static boolean v(TreeNode root, int[] depth) {
        if (root == null) {
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if (v(root.left, left) && v(root.right, right)) {
            depth[0] = 1 + Math.max(left[0], right[0]);
            return Math.abs(left[0] - right[0]) < 2;
        }
        return false;
    }
}