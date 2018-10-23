package com.tf.alg.leetcode;

import com.tf.alg.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by tingfang
 * 2018-09-18
 */
public class Q101 {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return solutionWithLoop(root);
    }

    private static boolean solutionWithLoop(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        int count = 0;
        int curSize = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
                list.add(temp.left.val);
            } else {
                list.add(null);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
                list.add(temp.right.val);
            } else {
                list.add(null);
            }
            if (++count == curSize) {
                int i = 0;
                int j = list.size() - 1;
                while (i < j) {
                    Integer first = list.get(i);
                    Integer last = list.get(j);
                    if (!Objects.equals(first, last)) {
                        return false;
                    }
                    i++;
                    j--;
                }
                list.clear();
                curSize = queue.size();
                count = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left(2).left(3);
        root.left.right(4);
        root.right(2).left(4);
        root.right.right(3);

        System.out.println(isSymmetric(root));
    }
}
