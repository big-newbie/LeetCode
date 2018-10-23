package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-08-11
 */
public class Q9 {
    private static boolean isPalindrome(int x) {
        if (x < 0 || x == 10) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int p = 10;
        int[] nums = new int[10];
        int i = 0, j = 0;
        while (x / p > 0) {
            nums[j++] = x % p;
            x /= p;
        }
        nums[j] = x;
        while (i < j) {
            if (nums[i++] != nums[j--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("isPalindrome(1234) = " + isPalindrome(1234));
        System.out.println("isPalindrome(1) = " + isPalindrome(1));
        System.out.println("isPalindrome(-2) = " + isPalindrome(-2));
        System.out.println("isPalindrome(12) = " + isPalindrome(12));
        System.out.println("isPalindrome(11) = " + isPalindrome(11));
        System.out.println("isPalindrome(121) = " + isPalindrome(121));
        System.out.println("isPalindrome(12321) = " + isPalindrome(12321));
        System.out.println("isPalindrome(123686321) = " + isPalindrome(123686321));
        System.out.println("isPalindrome(1002001) = " + isPalindrome(1002001));
        System.out.println("isPalindrome(10) = " + isPalindrome(10));
        System.out.println("isPalindrome(10021) = " + isPalindrome(10021));
        System.out.println("isPalindrome(12200001) = " + isPalindrome(12200001));
    }
}
