package com.tf.alg.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-10-26
 */
public class Q78 {
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);
        Deque<Integer> temp = new LinkedList<>();
        bt(lists, temp, nums, 0);
        return lists;
    }

    private static void bt(List<List<Integer>> lists, Deque<Integer> temp, int[] nums, int index) {
        lists.add(new LinkedList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.offer(nums[i]);
            bt(lists, temp, nums, i + 1);
            temp.pollLast();
        }
    }

    public static void main(String[] args) {
        System.out.println("subsets(new int[]{1,2,3}) = " + subsets(new int[]{1, 2, 3}));
    }
}
