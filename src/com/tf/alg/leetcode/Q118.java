package com.tf.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-09-18
 */
public class Q118 {
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        if (numRows == 0) {
            return lists;
        }
        List<Integer> list = new ArrayList<>(1);
        list.add(1);
        lists.add(list);
        if (numRows > 1) {
            list = new ArrayList<>(2);
            list.add(1);
            list.add(1);
            lists.add(list);
        }
        for (int i = 3; i <= numRows; i++) {
            list = new ArrayList<>(i);
            list.add(1);
            List<Integer> prev = lists.get(i - 2);
            for (int j = 1; j < i - 1; j++) {
                list.add(prev.get(j - 1) + prev.get(j));
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}