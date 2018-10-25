package com.tf.alg.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-10-25
 */
public class Q90 {

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        Deque<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        bt(lists, list, nums, 0);
        return lists;
    }

    private static void bt(List<List<Integer>> lists, Deque<Integer> integers, int[] nums, int index) {
        lists.add(new LinkedList<>(integers));
        for (int i = index; i < nums.length; i++) {
            if (i == index || nums[i] != nums[i - 1]) {
                integers.push(nums[i]);
                bt(lists, integers, nums, i + 1);
                integers.pop();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("subsetsWithDup({1,2,2}) = " + subsetsWithDup(new int[]{1, 2, 2}));
    }
}
