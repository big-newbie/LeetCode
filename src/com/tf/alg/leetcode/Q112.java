package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

/**
 * Created by tingfang
 * 2018-09-18
 */
public class Q112 {
    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return has(root, sum);
    }

    private static boolean has(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return (root.left != null && has(root.left, sum - root.val)) || (root.right != null && has(root.right, sum - root.val));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                null,
                                new TreeNode(1))));
        hasPathSum(root, 22);
    }
}