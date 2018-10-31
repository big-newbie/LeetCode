package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by tingfang
 * 2018-10-31
 */
public class Q199 {
    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curSize = 0;
        int nextSize = 1;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t.left != null) {
                queue.offer(t.left);
            }
            if (t.right != null) {
                queue.offer(t.right);
            }
            if (++curSize == nextSize) {
                ret.add(t.val);
                nextSize = queue.size();
                curSize = 0;
            }
        }
        return ret;
    }
}