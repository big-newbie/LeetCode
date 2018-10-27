package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

/**
 * Created by tingfang
 * 2018-10-28
 */
public class Q106 {

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return bt(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode bt(int[] inorder, int ii, int ij, int[] postorder, int pi, int pj) {
        if (ii > ij) {
            return null;
        }
        if (ii == ij) {
            return new TreeNode(inorder[ii]);
        }
        int r = postorder[pj];
        TreeNode root = new TreeNode(r);
        int iii = ii;
        int pii = pi;
        while (inorder[iii] != r) {
            iii++;
            pii++;
        }
        root.left = bt(inorder, ii, iii - 1, postorder, pi, pii - 1);
        root.right = bt(inorder, iii + 1, ij, postorder, pii, pj - 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{9,3,  15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(root);
    }
}