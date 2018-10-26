package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-10-26
 */
public class Q98 {
    private static boolean isValidBST(TreeNode root) {//TODO 效率堪忧。。。
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp.val);
            root = temp.right;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
