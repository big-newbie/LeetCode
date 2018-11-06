package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-11-06
 */
public class Q145 {
    private static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        pt(root, list);
        return list;
    }

    private static void pt(TreeNode root, List<Integer> list) {
        if (root != null) {
            pt(root.left, list);
            pt(root.right, list);
            list.add(root.val);
        }
    }

    private static List<Integer> postorderTraversal(TreeNode root) {//TODO
        List<Integer> list = new LinkedList<>();
        pt(root, list);
        return list;
    }
}
