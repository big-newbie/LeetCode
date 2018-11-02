package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-11-02
 */
public class Q95 {
    private static List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<>();
        }
        List<List<TreeNode>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            dp.add(new LinkedList<>());
        }
        dp.get(0).add(null);
        dp.get(1).add(new TreeNode(-1));
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                List<TreeNode> left = dp.get(j - 1);
                List<TreeNode> right = dp.get(i - j);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(-1);
                        root.left = copy(l);
                        root.right = copy(r);
                        dp.get(i).add(root);
                    }
                }
            }
        }
        for (TreeNode treeNode : dp.get(n)) {
            assign(treeNode, new int[1]);
        }
        return dp.get(n);
    }

    private static TreeNode copy(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode _r = new TreeNode(root.val);
        _r.left = copy(root.left);
        _r.right = copy(root.right);
        return _r;
    }

    private static void assign(TreeNode root, int[] num) {
        if (root == null) {
            return;
        }
        assign(root.left, num);
        root.val = ++num[0];
        assign(root.right, num);
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        System.out.println(treeNodes);
    }
}