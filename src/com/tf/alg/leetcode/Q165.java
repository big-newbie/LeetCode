package com.tf.alg.leetcode;

/**
 * Created by tingfang
 * 2018-10-28
 */
public class Q165 {
    private static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < v1.length && j < v2.length) {
            int vi = Integer.parseInt(v1[i]);
            int vj = Integer.parseInt(v2[j]);
            if (vi != vj) {
                if (vi < vj) {
                    return -1;
                } else {
                    return 1;
                }
            }
            i++;
            j++;
        }
        if (v1.length > v2.length) {
            for (; i < v1.length; i++) {
                if (Integer.parseInt(v1[i]) != 0) {
                    return 1;
                }
            }
        } else if (v1.length < v2.length) {
            for (; j < v2.length; j++) {
                if (Integer.parseInt(v2[j]) != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
    }
}
