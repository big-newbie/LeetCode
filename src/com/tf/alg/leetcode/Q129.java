package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

/**
 * Created by tingfang
 * 2018-10-27
 */
public class Q129 {
    private static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] holder = new int[1];
        dfs(root, holder, new int[1]);
        return holder[0];
    }

    private static void dfs(TreeNode root, int[] holder, int[] temp) {
        temp[0] = temp[0] * 10 + root.val;
        if (root.left == null && root.right == null) {
            holder[0] += temp[0];
        }
        if (root.left != null) {
            dfs(root.left, holder, temp);
        }
        if (root.right != null) {
            dfs(root.right, holder, temp);
        }
        temp[0] /= 10;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(sumNumbers(root));
    }
}
