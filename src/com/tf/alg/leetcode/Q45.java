package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-11-04
 */
public class Q45 {
    private static int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int s = nums[0];
        if (s + 1 >= nums.length) {
            return 1;
        }
        int ms = s;
        int mi = 0;
        int ret = 0;
        for (int j = 1; j < nums.length; j++) {
            if (ms + mi < nums[j] + j) {
                ms = nums[j];
                mi = j;
            }
            if (--s == 0) {
                ret++;
                s = ms + mi - j;
                if (mi + ms + 1 >= nums.length) {
                    return ++ret;
                }
            }
        }
        return ++ret;
    }

    public static void main(String[] args) {
        System.out.println("jump(new int[]{2,3,1,1,4}) = " + jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println("jump(new int[]{4,5,6,7,8}) = " + jump(new int[]{4, 5, 6, 7, 8}));
        System.out.println("jump(new int[]{1,1,1,1,1}) = " + jump(new int[]{1, 1, 1, 1, 1}));
        System.out.println("jump(new int[]{1,3,3,1,1}) = " + jump(new int[]{1, 3, 3, 1, 1}));
        System.out.println("jump(new int[]{1,2,3,4,1,2,1,1,1}) = " + jump(new int[]{1, 2, 3, 4, 1, 2, 1, 1, 1}));
        System.out.println("jump(new int[]{3,4,3,2,5,4,3}) = " + jump(new int[]{3, 4, 3, 2, 5, 4, 3}));
        System.out.println(jump(new int[]{2, 9, 6, 5, 7, 0, 7, 2, 7, 9, 3, 2, 2, 5, 7, 8, 1, 6, 6, 6, 3, 5, 2, 2, 6, 3}));
    }
}