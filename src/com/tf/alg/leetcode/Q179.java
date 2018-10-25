package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-25
 */
public class Q179 {
    private static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        int[][] digits = new int[nums.length][];
        int[] temp = new int[10];
        for (int i = 0; i < nums.length; i++) {
            digits[i] = convert(nums[i], temp);
        }
        sort1(digits);
        StringBuilder sb = new StringBuilder();
        for (int[] digit : digits) {
            for (int i : digit) {
                sb.append(i);
            }
        }
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }
        return sb.substring(i);
    }

    private static void sort(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int mi = i;
            for (int j = i; j < arr.length; j++) {
                if (gt(arr[j], arr[mi])) {
                    mi = j;
                }
            }
            int[] temp = arr[i];
            arr[i] = arr[mi];
            arr[mi] = temp;
        }
    }

    private static void sort1(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            int[] temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (gt(temp, arr[j])) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    private static int[] convert(int n, int[] arr) {
        if (n == 0) {
            return new int[]{0};
        }
        int len = 0;
        while (n > 0) {
            arr[len++] = n % 10;
            n /= 10;
        }
        int[] ret = new int[len];
        System.arraycopy(arr, 0, ret, 0, len);
        len--;
        for (int i = 0; i < len; i++, len--) {
            int temp = ret[i];
            ret[i] = ret[len];
            ret[len] = temp;
        }
        return ret;
    }

    private static boolean gt(int[] a, int[] b) {
        int total = a.length + b.length;
        int count = 0;
        int ai = 0;
        int bi = 0;
        int[] ta = a;
        int[] tb = b;
        while (count < total) {
            if (ai == a.length) {
                ta = b;
                ai = 0;
            }
            if (bi == b.length) {
                tb = a;
                bi = 0;
            }
            if (ta[ai] < tb[bi]) {
                return false;
            } else if (ta[ai] > tb[bi]) {
                return true;
            }
            count++;
            ai++;
            bi++;
        }
        return true;
    }

    private static boolean gt1(int[] a, int[] b) {
        int[] ta = new int[a.length + b.length];
        int[] tb = new int[a.length + b.length];
        System.arraycopy(a, 0, ta, 0, a.length);
        System.arraycopy(b, 0, tb, 0, b.length);
        System.arraycopy(a, 0, tb, b.length, a.length);
        System.arraycopy(b, 0, ta, a.length, b.length);
        int ai = 0;
        int bi = 0;
        while (ai < ta.length) {
            if (ta[ai] < tb[bi]) {
                return false;
            } else if (ta[ai] > tb[bi]) {
                return true;
            }
            ai++;
            bi++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{0}));
        System.out.println(gt(new int[]{3}, new int[]{3, 4}));
    }
}