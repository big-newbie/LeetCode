package com.tf.alg.backup;

import com.tf.alg.ListNode;
import com.tf.alg.TreeNode;

/**
 * Created by tingfang
 * 2018-07-26
 */
public class A {
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode s = pHead;
        ListNode f = pHead;

        do {
            f = f.next;
            if (f == null) {
                return null;
            }
            f = f.next;
            if (f == null) {
                return null;
            }
            s = s.next;
        } while (f != s);
        f = pHead;
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return f;
    }

    public static void main(String[] args) {
        int[] arr = {6, -3, -21, 17, -15, 12, 2, 2};
        System.out.println(FindGreatestSumOfSubArray(arr));
        System.out.println(NumberOf1(4));

        System.out.println(EntryNodeOfLoop(ListNode.create(1, 2, 3, 4, 5, 6)));
    }

    ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2, ListNode p2) {
        ListNode p1 = pHead1;
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int p1 = 1;
        int p2 = 1;
        ListNode tp1 = pHead1;
        ListNode tp2 = pHead2;
        while (tp1.next != null) {
            tp1 = tp1.next;
            p1++;
        }
        while (tp2 != null) {
            tp2 = tp2.next;
            p2++;
        }
        if (tp1 != tp2) {
            return null;
        }
        tp1 = pHead1;
        tp2 = pHead2;
        if (p1 > p2) {
            while (p1-- > p2) {
                tp1 = tp1.next;
            }
        } else {
            while (p2-- > p1) {
                tp2 = tp2.next;
            }
        }
        while (tp1 != null) {
            if (tp1 == tp2) {
                return tp1;
            }
            tp1 = tp1.next;
            tp2 = tp2.next;
        }
        throw new RuntimeException("can`t happen");
    }

    static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = (n & (n - 1));
            count++;
        }
        return count;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null) {
            return root.val <= root.right.val && IsBalanced_Solution(root.right);
        }
        if (root.right == null) {
            return root.val >= root.left.val && IsBalanced_Solution(root.left);
        }
        return root.val >= root.left.val && root.val <= root.right.val
                && IsBalanced_Solution(root.right) && IsBalanced_Solution(root.left);
    }

    static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException();
        }
        if (array.length == 1) {
            return array[0];
        }
        int result = array[0];
        int temp = 0;
        for (int a : array) {
            temp += a;
            if (temp > result) {
                result = temp;
            }
            if (temp < 0) {
                temp = 0;
            }
        }
        return result;
    }
}