package com.tf.alg;

import com.tf.alg.ListNode.Builder;

import javax.xml.ws.Holder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by tingfang
 * 2018-08-08
 */
public class Array {
    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }
        int[] all = new int[index];
        all[0] = 1;
        int i = 0, j = 0, k = 0, n = 1;
        while (n < index) {
            int ni = all[i] * 2;
            int nj = all[j] * 3;
            int nk = all[k] * 5;
            int min = min(ni, nj, nk);
            all[n++] = min;
            if (ni == min) {
                i++;
            }
            if (nj == min) {
                j++;
            }
            if (nk == min) {
                k++;
            }
        }
        return all[index - 1];
    }

    private static int min(int... ints) {
        int r = ints[0];
        for (int i : ints) {
            if (i < r) {
                r = i;
            }
        }
        return r;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length < k || k <= 0) {
            return list;
        }
        if (input.length == k) {
            for (int i : input) {
                list.add(i);
            }
            return list;
        }
        int low = 0;
        int high = input.length - 1;
        int p;
        do {
            p = partition(input, low, high);
            if (p < k) {
                low = p + 1;
            } else if (p > k) {
                high = p - 1;
            }
        } while (p != k);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private static int partition(int[] input, int low, int high) {
        int key = input[low];
        while (low < high) {
            while (low < high && input[high] >= key) {
                high--;
            }
            if (low < high) {
                input[low] = input[high];
                low++;
            }
            while (low < high && input[low] <= key) {
                low++;
            }
            if (low < high) {
                input[high] = input[low];
                high--;
            }
        }
        input[low] = key;
        return low;
    }

    public static int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int p = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int temp = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (temp > array[j] && ++p == 1000000007) {
                    p = 0;
                }
            }
        }
        return p;
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int xl = 0;
        int xh = matrix.length - 1;
        int yl = 0;
        int yh = matrix[0].length - 1;
        while (xl < xh && yl < yh) {
            int x = xl;
            int y = yl;
            while (y < yh) {
                list.add(matrix[x][y]);
                y++;
            }
            while (x < xh) {
                list.add(matrix[x][y]);
                x++;
            }
            while (y > yl) {
                list.add(matrix[x][y]);
                y--;
            }
            while (x > xl) {
                list.add(matrix[x][y]);
                x--;
            }
            xl++;
            xh--;
            yl++;
            yh--;
        }
        while (xl < xh && yl == yh) {
            list.add(matrix[xl++][yl]);
        }
        while (xl == xh && yl <= yh) {
            list.add(matrix[xl][yl++]);
        }
        return list;
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return rc(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode rc(int[] pre, int pl, int ph, int[] in, int il, int ih) {
        if (pl > ph) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[pl]);
        if (pl != ph) {
            for (int i = il; i <= ih; i++) {
                if (in[i] == pre[pl]) {
                    treeNode.left = rc(pre, pl + 1, pl + i - il, in, il, i - 1);
                    System.out.println(pl + " " + ph + " " + il + " " + ih + " " + i);
                    System.out.println(pl + i - il + 1);
                    treeNode.right = rc(pre, pl + i - il + 1, ph, in, i + 1, ih);
                    break;
                }
            }
        }
        return treeNode;
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        return root1 != null && root2 != null && (isSubTreeWithSameRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2));
    }

    private boolean isSubTreeWithSameRoot(TreeNode root1, TreeNode root2) {
        return root2 == null || (root1 != null && root1.val == root2.val && isSubTreeWithSameRoot(root1.left, root2.left) && isSubTreeWithSameRoot(root1.right, root2.right));
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
//        return f1(head, k);
        return f2(head, k);
    }


    private static ListNode f1(ListNode head, int k) {
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (k > 0 && !stack.isEmpty()) {
            head = stack.pop();
            k--;
        }
        if (k > 0) {
            return null;
        }
        return head;
    }

    private static ListNode f2(ListNode head, int k) {
        ListNode cur = head;
        while (k > 0 && cur != null) {
            cur = cur.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        while (cur != null) {
            head = head.next;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);


        int[][] a = new int[5][2];
        System.out.println(Arrays.deepToString(a));
        System.out.println(a.length);
        System.out.println(a[0].length);

//        int[] array = new int[200000];
//        for (int i = 0; i < 100; i++) {
//            array[100 - i - 1] = i;
//        }
        int[] array = {3, 2, 1};
        System.out.println("InversePairs  " + InversePairs(array));

        System.out.println("printMatrix");
        int x = 4;
        int y = 5;
        int[][] ma = new int[x][y];
        int c = 1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                ma[i][j] = c++;
            }
        }
        System.out.println(Arrays.deepToString(ma));
        System.out.println(printMatrix(ma));

        System.out.println(GetLeastNumbers_Solution(new int[]{2, 5, 7, 8, 9, 3, 4, 5}, 4));

        System.out.println(GetUglyNumber_Solution(100000));


        ListNode listNode = Builder.newBuilder().next(5, 4, 3, 2, 1).build();
        f1(listNode, 1).print();
        f2(listNode, 3).print();
        f1(listNode, 5).print();
        f2(listNode, 5).print();
        System.out.println(f1(listNode, 6) == null && f2(listNode, 6) == null);

        System.out.println("deleteDuplication");
        ListNode deleteDuplication = deleteDuplication(Builder.newBuilder().next(5, 5, 4, 4, 3, 3, 3, 2, 2, 1, 1).build());
        if (deleteDuplication == null) {
            System.out.println("deleteDuplication == null");
        } else {
            deleteDuplication.print();
        }


        ListNode listNode_a = Builder.newBuilder().next(1, 7, 7, 9, 9).build();
        ListNode listNode_b = Builder.newBuilder().next(1, 1, 3).build();
        addTwoNumbers(listNode_a, listNode_b).print();
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        return dd2(pHead);
    }

    private static ListNode dd2(ListNode pHead) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        newHead.next = pHead;
        while (pHead != null && pHead.next != null) {
            if (pHead.val == pHead.next.val) {
                while (pHead.next != null && pHead.val == pHead.next.val) {
                    pHead = pHead.next;
                }
                cur.next = pHead.next;
                pHead = pHead.next;
            } else {
                cur.next = pHead;
                cur = cur.next;
                pHead = pHead.next;
            }
        }
        return newHead.next;
    }

    private ListNode dd1(ListNode pHead) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (pHead != null && pHead.next != null) {
            if (pHead.val == pHead.next.val) {
                do {
                    pHead = pHead.next;
                } while (pHead.next != null && pHead.val == pHead.next.val);
                pHead = pHead.next;
            } else {
                tail.next = pHead;
                tail = tail.next;
                pHead = pHead.next;
                tail.next = null;
            }
        }
        if (pHead != null) {
            tail.next = pHead;
        }
        return head.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = l1;
        ListNode tail = l1;
        boolean carry = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + (carry ? 1 : 0);
            carry = false;
            if (sum >= 10) {
                carry = true;
                sum -= 10;
            }
            l1.val = sum;
            tail = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (carry && l1 != null) {
            int sum = l1.val + 1;
            carry = false;
            if (sum >= 10) {
                carry = true;
                sum -= 10;
            }
            l1.val = sum;
            tail = l1;
            l1 = l1.next;
        }
        while (carry && l2 != null) {
            int sum = l2.val + 1;
            carry = false;
            if (sum >= 10) {
                carry = true;
                sum -= 10;
            }
            l2.val = sum;
            tail.next = l2;
            tail = l2;
            l2 = l2.next;
        }
        if (carry) {
            tail.next = new ListNode(1);
        } else if (l1 == null) {
            tail.next = l2;
        } else {
            tail.next = l1;
        }
        return head;
    }
}
