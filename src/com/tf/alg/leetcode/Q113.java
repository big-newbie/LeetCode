package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-10-27
 */
public class Q113 {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        search(lists, new LinkedList<>(), root, sum);
        return lists;
    }

    private static void search(List<List<Integer>> lists, List<Integer> temp, TreeNode root, int sum) {
        temp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            lists.add(new LinkedList<>(temp));
        } else {
            if (root.left != null) {
                search(lists, temp, root.left, sum - root.val);
            }
            if (root.right != null) {
                search(lists, temp, root.right, sum - root.val);
            }
        }
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(pathSum(root, 22));
    }
}
