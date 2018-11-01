package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-11-01
 */
public class Q96 {
    private static int numTrees(int n) {
        if (n <= 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int r = 0;
            for (int j = 1; j <= i; j++) {
                r += dp[j - 1] * dp[i - j];
            }
            dp[i] = r;
        }
        return dp[n];
    }

    private static int numTrees1(int n) {
        if (n <= 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            ret += numTrees1(i - 1) * numTrees1(n - i);
        }
        return ret;
    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            System.out.println("numTrees1(" + i + ") = " + numTrees1(i));
        }
        System.out.println(System.currentTimeMillis() - s);
        s = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            System.out.println("numTrees(" + i + ") = " + numTrees(i));
        }
        System.out.println(System.currentTimeMillis() - s);
    }
}
