package com.tf.alg.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by tingfang
 * 2018-10-24
 */
public class Q71 {
    private static String simplifyPath(String path) {
        if (path == null || path.length() < 1) {
            return path;
        }
        Deque<String> stack = new LinkedList<>();
        String[] strs = path.split("/");
        for (String s : strs) {
            if (!s.isEmpty() && !s.equals(".")) {
                if (s.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(s);
                }
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("simplifyPath(\"/home/foo//..//\") = " + simplifyPath("/home/foo//..//"));
        System.out.println("simplifyPath(\"/a/./b/../../c/\") = " + simplifyPath("/a/./b/../../c/"));
        System.out.println("simplifyPath(\"/a/b/c/../d\") = " + simplifyPath("/a/b/c/../d"));
        System.out.println("simplifyPath(\"/../\") = " + simplifyPath("/../"));
        System.out.println("simplifyPath(\"/abc/...\") = " + simplifyPath("/abc/..."));
    }
}
