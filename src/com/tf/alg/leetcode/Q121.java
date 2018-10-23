package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-08-15
 */
public class Q121 {
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6,};
        System.out.println(maxProfit(prices));
    }
}
