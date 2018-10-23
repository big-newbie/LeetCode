package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-09-19
 */
public class Q169 {

    private static int majorityElement1(int[] nums) {
        int ret = 0;
        int count = 0;
        for (int i : nums) {
            if (count == 0) {
                ret = i;
            }
            if (ret != i) {
                count--;
            } else {
                count++;
            }
        }
        return ret;
    }

    private static int majorityElement(int[] nums) {
        int m = nums.length / 2;
        int p = -1;
        int low = 0;
        int high = nums.length - 1;
        while (p != m) {
            p = partition(nums, low, high);
            if (p < m) {
                low = p + 1;
            } else if (p > m) {
                high = p - 1;
            }
        }
        return nums[p];
    }

    private static int partition(int[] nums, int low, int high) {
        int m = getMid(nums, low, high);
        swap(nums, low, m);
        int key = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= key) {
                high--;
            }
            if (low < high) {
                nums[low] = nums[high];
                low++;
            }
            while (low < high && nums[low] <= key) {
                low++;
            }
            if (low < high) {
                nums[high] = nums[low];
                high--;
            }
        }
        nums[low] = key;
        return low;
    }

    private static int getMid(int[] nums, int i, int j) {
        int m = (i + j) / 2;
        if (nums[i] > nums[j]) {
            if (nums[j] > nums[m]) {
                return j;
            } else if (nums[i] > nums[m]) {
                return m;
            } else {
                return i;
            }
        } else {
            if (nums[i] > nums[m]) {
                return i;
            } else if (nums[j] > nums[m]) {
                return m;
            } else {
                return j;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement1(nums));
    }
}