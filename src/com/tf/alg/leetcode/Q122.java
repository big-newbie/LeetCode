package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-23
 */
public class Q122 {
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                max = max + prices[i + 1] - prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("maxProfit({7,1,5,3,6,4}) = " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("maxProfit({7,1,5,3,6,4}) = " + maxProfit(new int[]{7, 6, 5, 4, 3, 2, 1}));
        System.out.println("maxProfit({7,1,5,3,6,4}) = " + maxProfit(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
