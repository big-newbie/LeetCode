package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-27
 */
public class Q189 {

    private void rotate(int[] nums, int k) {//O(n * k)
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int prev, next;
        while (k-- > 0) {// 2 * k > length 可以反向移动 length - k 次   O(min(k, length - k) * n)
            prev = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                next = nums[i + 1];
                nums[i + 1] = prev;
                prev = next;
            }
            nums[0] = prev;
        }
    }

    private void rotate1(int[] nums, int k) {//TODO O(n) time 0(1) space
    }
}