package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by tingfang
 * 2018-09-17
 */
public class Q107 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curSize = 1;
        List<Integer> list = new LinkedList<>();
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            list.add(temp.val);
            if (curSize == ++count) {
                ret.addFirst(list);
                list = new LinkedList<>();
                count = 0;
                curSize = queue.size();
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                new TreeNode(15), new TreeNode(7)));
        levelOrderBottom(root);
    }
}
