package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

/**
 * Created by tingfang
 * 2018-10-28
 */
public class Q105 {
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return bt(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode bt(int[] preorder, int pi, int pj, int[] inorder, int ii, int ij) {
        if (pi > pj) {
            return null;
        }
        if (pi == pj) {
            return new TreeNode(preorder[pi]);
        }
        int r = preorder[pi];
        TreeNode root = new TreeNode(r);
        int _ii = ii;
        int _pi = pi;
        while (inorder[_ii] != r) {
            _ii++;
            _pi++;
        }
        root.left = bt(preorder, pi + 1, _pi, inorder, ii, _ii - 1);
        root.right = bt(preorder, _pi + 1, pj, inorder, _ii + 1, ij);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(root);
    }
}
