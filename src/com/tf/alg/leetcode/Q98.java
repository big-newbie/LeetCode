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
    private static boolean isValidBST(TreeNode root) {
        return isValidBST1(root);
    }

    private static boolean isValidBST4(TreeNode root, boolean[] lt, int[] cur) {//TODO
        return isValidBST4(root, lt, cur) && isValidBST4(root, lt, cur);
    }

    private static boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Integer prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            if (prev != null && prev <= temp.val) {
                return false;
            }
            prev = temp.val;
            root = temp.right;
        }
        return true;
    }

    private static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            if (!numStack.isEmpty() && temp.val <= numStack.peek()) {
                return false;
            }
            numStack.push(temp.val);
            root = temp.right;
        }
        return true;
    }

    private static boolean isValidBST1(TreeNode root) {//效率堪忧。。。击败 0.9%。。。
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
