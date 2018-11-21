package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-08-11
 */
public class Q4 {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return median(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return median(nums1);
        }
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int i;
        int j;
        int imin = 0;
        int imax = m;
        int half = (m + n + 1) >> 1;
        while (imin <= imax) {
            i = (imin + imax) >> 1;
            j = half - i;
            if (i < imax && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            } else if (i > imin && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else {
                int left;
                if (i == 0) {
                    left = nums2[j - 1];
                } else if (j == 0) {
                    left = nums1[i - 1];
                } else {
                    left = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if (((m + n) & 1) == 1) {
                    return left;
                }
                int right;
                if (i == m) {
                    right = nums2[j];
                } else if (j == n) {
                    right = nums1[i];
                } else {
                    right = Math.min(nums1[i], nums2[j]);
                }
                return (left + right) / 2D;
            }
        }
        throw new RuntimeException();
    }

    private static double median(int[] nums) {
        int m = nums.length / 2;
        if ((nums.length & 1) == 1) {
            return nums[m];
        }
        return (nums[m] + nums[m - 1]) / 2D;
    }


    public static void main(String[] args) {
        int[] nums2 = {5, 6, 7};
        int[] nums1 = {10};
        System.out.println(findMedianSortedArrays(nums2, nums1));
    }
}
