package com.tf.alg.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-11-12
 */
public class Q54 {
    @SuppressWarnings("all")//duplication
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int xl = 0;
        int xh = matrix.length - 1;
        int yl = 0;
        int yh = matrix[0].length - 1;
        while (xl < xh && yl < yh) {
            int x = xl;
            int y = yl;
            while (y < yh) {
                list.add(matrix[x][y]);
                y++;
            }
            while (x < xh) {
                list.add(matrix[x][y]);
                x++;
            }
            while (y > yl) {
                list.add(matrix[x][y]);
                y--;
            }
            while (x > xl) {
                list.add(matrix[x][y]);
                x--;
            }
            xl++;
            xh--;
            yl++;
            yh--;
        }
        while (xl == xh && yl <= yh) {
            list.add(matrix[xl][yl]);
            yl++;
        }
        while (xl <= xh && yl == yh) {
            list.add(matrix[xl][yl]);
            xl++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("spiralOrder(new int[][]{\n" +
                "                {1, 2, 3},\n" +
                "                {4, 5, 6},\n" +
                "                {7, 8, 9}\n" +
                "        }) = " + spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));

        System.out.println("spiralOrder(new int[][]{\n" +
                "                {1, 2, 3, 4},\n" +
                "                {5, 6, 7, 8},\n" +
                "                {9, 10, 11, 12}\n" +
                "        }) = " + spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));

        System.out.println("spiralOrder(new int[][]{{3},{2}}) = " + spiralOrder(new int[][]{{3}, {2}}));
    }
}
