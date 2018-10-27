package com.tf.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-10-27
 */
public class Q119 {
    private static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) {
            return list;
        }
        for (int i = 0; i <= rowIndex; i++) {
            int prev = 1;
            int temp;
            for (int j = 1; j < i; j++) {
                temp = list.get(j);
                list.set(j, prev + temp);
                prev = temp;
            }
            list.add(1);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getRow(2000));
    }
}
