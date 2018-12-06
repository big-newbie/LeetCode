package com.tf.alg;

/**
 * Created by tingfang
 * 2018-07-27
 */
public class ListNode {
    public int val;
    public ListNode next;

    public static ListNode create(int... vals) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int val : vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return head.next;
    }

    public ListNode(int val) {
        this.val = val;
    }


    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode t = this;
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        t = t.next;
        while (t != null) {
            sb.append(" → ").append(t.val);
            t = t.next;
        }
        System.out.println(sb);
    }
}