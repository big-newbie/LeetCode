package com.tf.alg.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-10-25
 */
public class Q77 {

    private static List<List<Integer>> combine(int n, int k) {//TODO
        List<List<Integer>> lists = new LinkedList<>();
        if (n == 0 || k == 0 || n < k) {
            return lists;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return lists;
    }

    public static void main(String[] args) {

    }
}
