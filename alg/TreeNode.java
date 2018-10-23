package com.tf.alg;

/**
 * Created by tingfang
 * 2018-07-27
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode left(Integer l) {
        left = new TreeNode(l);
        return left;
    }

    public TreeNode right(Integer r) {
        right = new TreeNode(r);
        return right;
    }
}