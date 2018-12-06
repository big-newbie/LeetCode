package com.tf.alg.backup;

import com.tf.alg.ListNode;
import com.tf.alg.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by keefe
 * 2018-12-06
 */
@SuppressWarnings("all")
public class BACKUP {

    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length < 2) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            int idx = numbers[i];
            if (idx < 0) {
                idx = -1 - idx;
            }
            if (numbers[idx] < 0) {
                duplication[0] = idx;
                return true;
            }
            numbers[idx] = -(numbers[idx] + 1);
        }
        return false;
    }

    private static ListNode merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = merge1(list1, list2.next);
            return list2;
        } else {
            list1.next = merge1(list1.next, list2);
            return list1;
        }
    }

    private static int partition(int[] array, int l, int h) {
        int key = array[h];
        int _l = l;
        int _h = h;
        while (l < h) {
            while (array[l] <= key && l < h) {
                l++;
            }
            if (l < h) {
                array[h] = array[l];
                h--;
            }
            while (array[h] >= key && l < h) {
                h--;
            }
            if (l < h) {
                array[l] = array[h];
                l++;
            }
        }
        int mid = array.length / 2;
        array[l] = key;
        if (l == mid) {
            return key;
        } else if (l < mid) {
            return partition(array, l + 1, _h);
        } else {
            return partition(array, _l, l - 1);
        }
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int key = partition(array, 0, array.length - 1);
        int limit = array.length / 2;
        int count = 0;
        for (int i : array) {
            if (i == key) {
                count++;
            }
            if (count > limit) {
                return key;
            }
        }
        return 0;
    }

    private static ListNode merge2(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(-1, null);
        ListNode head = temp;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return head.next;
    }

    private static TreeNode convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)) {
            return pRootOfTree;
        }
        if (pRootOfTree.left == null) {
            TreeNode convertedRight = convert1(pRootOfTree.right);
            pRootOfTree.right = convertedRight;
            convertedRight.left = pRootOfTree;
            return pRootOfTree;
        }
        if (pRootOfTree.right == null) {
            TreeNode convertedLeft = convert1(pRootOfTree.left);
            TreeNode temp = convertedLeft;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = pRootOfTree;
            pRootOfTree.left = temp;
            return convertedLeft;
        }
        TreeNode convertedRight = convert1(pRootOfTree.right);
        TreeNode convertedLeft = convert1(pRootOfTree.left);
        TreeNode temp = convertedLeft;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = pRootOfTree;
        pRootOfTree.left = temp;
        pRootOfTree.right = convertedRight;
        convertedRight.left = pRootOfTree;
        return convertedLeft;
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int n = (sum % 2 == 0) ? sum / 2 : (sum + 1) / 2;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        while (n > 1) {
            if (n % 2 == 1 && sum % n == 0) {
                int start = sum / n - n / 2;
                if (start > 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = start; i <= sum / n + n / 2; i++) {
                        list.add(i);
                    }
                    ret.add(list);
                }
            } else if (n % 2 == 0 && sum % n != 0 && sum * 2 % n == 0) {
                int start = sum / n - n / 2 + 1;
                if (start > 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = start; i <= sum / n + n / 2; i++) {
                        list.add(i);
                    }
                    ret.add(list);
                }
            }
            n--;
        }
        return ret;
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;
        find(paths, new ArrayList<>(), root, target);
        return paths;
    }

    public void find(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode root, int target) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                paths.add(path);
            }
            return;
        }
        ArrayList<Integer> path2 = new ArrayList<>(path);
        if (root.left != null) find(paths, path, root.left, target - root.val);
        if (root.right != null) find(paths, path2, root.right, target - root.val);
    }

    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        int zc = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                zc++;
            } else if (i < numbers.length - 1 && (numbers[i] - numbers[i + 1] == 0 || (zc += (numbers[i] - numbers[i + 1] + 1)) < 0)) {
                return false;
            }
        }
        return true;
    }

    public static int Fibonacci(int n) {
        int c = 0;
        int next = 1;
        while (n-- > 0) {
            next += c;
            c = next - c;
        }
        return c;
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return null;
        }
        int l = 0;
        int h = array.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (l < h) {
            if (array[l] + array[h] == sum) {
                list.add(array[l]);
                list.add(array[h]);
                return list;
            } else if (array[l] + array[h] > sum) {
                h--;
            } else {
                l++;
            }
        }
        return list;
    }

    private static ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = ReverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }

    private static ListNode ReverseList2(ListNode head) {
        ListNode cur = head;
        ListNode nxt = cur.next;
        head.next = null;
        while (nxt != null) {
            ListNode temp = nxt.next;
            nxt.next = cur;
            cur = nxt;
            nxt = temp;
        }
        return cur;
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return ReverseList1(head);
//        return ReverseList2(head);
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        ArrayDeque<Integer> push = new ArrayDeque<>();
        ArrayDeque<Integer> pop = new ArrayDeque<>();
        for (int i : pushA) {
            push.addLast(i);
        }
        for (int i : popA) {
            pop.addLast(i);
        }
        return isPopOrder(push, pop);
    }

    private static boolean isPopOrder(Deque<Integer> push, Deque<Integer> pop) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (!push.isEmpty()) {
            int t = push.pop();
            stack.push(t);
            while (!stack.isEmpty() && Objects.equals(pop.peek(), stack.peek())) {
                stack.pop();
                pop.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        int temp = 0;
        for (int i : array) {
            temp = (temp ^ i);
        }
        if (temp == 0) {
            return;
        }
        int d = 1;
        while ((temp & d) == 0) {
            d = d << 1;
        }
        for (int i : array) {
            if ((i & d) == 0) {
                num1[0] = num1[0] ^ i;
            } else {
                num2[0] = num2[0] ^ i;
            }
        }
    }

    public static void main(String[] args) {
        ListNode.create(1, 2, 3, 4, 5).print();
        ListNode listNode = ListNode.create(1, 2, 3, 4, 123);
        listNode.print();
        System.out.println("===========");
        ListNode reverseList1 = ReverseList1(listNode);
        reverseList1.print();

        ListNode reverseList2 = ReverseList2(ListNode.create(1, 2, 3, 4, 5));
        reverseList2.print();
//        System.out.println(f1(5, 3));
//        System.out.println(f2(5, 3));
//        System.out.println(f3(5, 3));

//        System.out.println(g2(new int[]{1, 2, 3, 3, 3, 3}, 3));
        System.out.println(Fibonacci(10));

        System.out.println();
        int[] n1 = new int[1];
        int[] n2 = new int[1];
        FindNumsAppearOnce(new int[]{1, 0, 6, 1, 1, 2, 6, 1231231141, 777777777, 1, 2, 0}, n1, n2);
        System.out.println(n1[0]);
        System.out.println(n2[0]);
        System.out.println("Pop order");
        int[] pushA = {1, 2, 3, 2, 3};
//        int[] popA = {4, 5, 3, 2, 1};
        int[] popA = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(pushA, popA));

        System.out.println("duplicate number");
        int[] duplication = new int[1];
        System.out.println(duplicate(pushA, 1, duplication));
        System.out.println(duplication[0]);

        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3, t2, t4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7, t6, t8);
        TreeNode t5 = new TreeNode(5, t3, t7);

        TreeNode convert = convert1(t5);
        System.out.println(convert);

        System.out.println("merge sorted list");
        ListNode mergeList = merge2(null, ListNode.create(1, 1, 3, 3, 5, 7, 7, 9));
        mergeList.print();
        int[] array = new int[]{1, 3, 3, 1, 2, 4, 5, 7, 1, 2};
        System.out.println("partition: " + partition(array, 0, array.length - 1));
        array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(array));

        System.out.println(FindContinuousSequence(14));
        int i = 700;
        while (i > 0) {
            if (FindContinuousSequence(i).isEmpty()) {
                System.out.println(i);
            }
            i--;
        }

        System.out.println("isContinuous() = " + isContinuous(new int[]{5, 2, 3, 1, 0}));

        int[] array1 = {2, 9, 4, 6, 8, 1, 3, 10, 5, 7,};
        reOrderArray(array1);
        System.out.println(Arrays.toString(array1));
    }

    public static void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        boolean swap;
        for (int i = array.length - 1; i > 0; i--) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if ((array[j] & 1) == 0 && (array[j + 1] & 1) == 1) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                return;
            }
        }
    }

    public void f1(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            if ((array[i] & 1) != 0) {
                int temp = array[i];
                int j = i - 1;
                for (; j >= 0 && (array[j] & 1) == 0; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
    }

    private char[] chars = new char[52];

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] strChars = str.toCharArray();
        for (char strChar : strChars) {
            chars[index(strChar)]++;
        }
        for (int i = 0; i < strChars.length; i++) {
            if (chars[index(strChars[i])] == 1) {
                return i;
            }
        }
        return -1;
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 0) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (pRoot != null || !stack.isEmpty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if (!stack.isEmpty()) {
                pRoot = stack.pop();
                if (--k == 0) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }

    private int index(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        return c - 'A' + 26;
    }

    private static ArrayList<ArrayList<Integer>> f1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        cur.offer(pRoot);
        ArrayList<Integer> integers = new ArrayList<>();
        while (!cur.isEmpty()) {
            TreeNode t = cur.poll();
            integers.add(t.val);
            if (t.left != null) {
                next.offer(t.left);
            }
            if (t.right != null) {
                next.offer(t.right);
            }
            if (cur.isEmpty()) {
                list.add(integers);
                Queue<TreeNode> temp = cur;
                cur = next;
                next = temp;
                integers = new ArrayList<>();
            }
        }
        return list;
    }

    public int LastRemaining_Solution(int n, int m) {
        return f1(n, m);
    }

    private static int f1(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int r = 0;
        for (int i = 2; i <= n; i++) {
            r = (r + m) % i;
        }
        return r;
    }

    private static int f2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (f2(n - 1, m) + m % n) % n;
    }

    private static int f3(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n];
        int count = 0;
        int idx = -1;
        int t = n;
        while (t > 0) {
            if (++idx == n) {
                idx = 0;
            }
            if (array[idx] != -1) {
                if (++count == m) {
                    t--;
                    array[idx] = -1;
                    count = 0;
                }
            }
        }
        return idx;
    }

    public int GetNumberOfK(int[] array, int k) {
        return g1(array, k);
    }

    private static int g2(int[] array, int k) {
        int l = 0;
        int h = array.length - 1;

        while (l < h) {
            int m = h - ((h - l) >> 1);
            if (array[m] > k) {
                h = m - 1;
            } else if (array[m] < k) {
                l = m + 1;
            } else {
                return findH(array, k, m + 1, h) - findL(array, k, l, m - 1) + 1;
            }
        }
        return array[l] == k ? 1 : 0;
    }

    private static int findH(int[] array, int target, int l, int h) {
        while (l < h) {
            int m = h - ((h - l) >> 1);
            if (array[m] == target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return array[h] == target ? h : h - 1;
    }

    private static int findL(int[] array, int target, int l, int h) {
        while (l < h) {
            int m = h - ((h - l) >> 1);
            if (array[m] == target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return array[l] == target ? l : l + 1;
    }

    private int g1(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array[0] == array[array.length - 1]) {
            return k == array[0] ? array.length : 0;
        }
        int l = 0;
        int h = array.length - 1;
        while (l < h) {
            int m = (l + h) >> 1;
            if (array[m] == k) {
                int r = 1;
                int i = m;
                while (--i >= l && array[i] == k) {
                    r++;
                }
                while (++m <= h && array[m] == k) {
                    r++;
                }
                return r;
            } else if (array[m] < k) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return array[l] == k ? 1 : 0;
    }
}