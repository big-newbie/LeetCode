package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-23
 */
public class Q172 {
    private static int trailingZeros(int n) {

        if (n < 5) {
            return 0;
        }
        int ret = 0;
        n = n / 5 * 5;
        while (n > 0) {
            int temp = n;
            do {
                ret += 1;
                temp /= 5;
            } while (temp % 5 == 0);
            n -= 5;
        }
        return ret;
    }

    private static int trailingZeros1(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("trailingZeros(5) = " + trailingZeros(5));
        System.out.println("trailingZeros(8) = " + trailingZeros(8));
        System.out.println("trailingZeros(12) = " + trailingZeros(12));
        System.out.println("trailingZeros(26) = " + trailingZeros(26));
        System.out.println("trailingZeros(91) = " + trailingZeros(91));
        System.out.println("trailingZeros(2147483647) = " + trailingZeros(2147483647));
    }
}
