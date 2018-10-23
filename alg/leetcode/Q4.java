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
        int l1 = nums1.length;
        int l2 = nums2.length;
        int low = 0;
        int high = nums1.length;
        int i;
        int j;
        int left;
        boolean isOdd = ((l1 + l2) & 1) == 1;
        while (low < high) {
            i = (low + high) >> 1;
            j = (l1 + l2 + 1 - low - high) >> 1;
            if (i == 0 || i == l1) {
                if (i == 0) {
                    left = nums2[j - 1];
                } else {
                    left = nums1[i - 1];
                }
                if (isOdd) {
                    return left;
                }
                int right;
                if (i == l1) {
                    right = nums2[j];
                } else {
                    right = nums1[i];
                }
                return (left + right) / 2.0;
            } else if (nums1[i - 1] > nums2[j]) {
                high = i - 1;
            } else if (nums2[j - 1] > nums1[i]) {
                low = i + 1;
            } else if (nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]) {
                return isOdd ? Math.max(nums1[i - 1], nums2[j - 1]) : (Math.max(nums1[i - 1], nums2[j - 1]) + Math.min(nums1[i], nums2[j])) / 2.0;
            }
        }
        return 0;
    }

    private static int median(int[] nums) {
        int m = nums.length / 2;
        if ((nums.length & 1) == 1) {
            return nums[m];
        }
        return (nums[m] + nums[m - 1]) >> 1;
    }


    public static void main(String[] args) {
        int[] nums2 = {5, 6, 7};
        int[] nums1 = {1, 3, 4, 4, 5};
        System.out.println(findMedianSortedArrays(nums2, nums1));
    }
}
