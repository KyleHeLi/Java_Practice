package com.leetcode.medium;

import com.leetcode.common.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        ListNode pre = null;
        ListNode current = head;
        ListNode next = current;
        boolean headChanged = false;
        while (current != null) {
            next = current.next;
            if (next == null) break;

            current.next = next.next;
            next.next = current;
            if (!headChanged) {
                head = next;
                headChanged = true;
            }
            if (pre != null) {
                pre.next = next;
            }
            pre = current;
            current = current.next;
            next = current;

        }

        return head;
    }

    public static void main(String[] args) {
        SwapNodesInPairs test = new SwapNodesInPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode res = test.swapPairs(head);
        System.out.println(res);

        head = null;
        res = test.swapPairs(head);
        System.out.println(res);

        head = new ListNode(1);
        res = test.swapPairs(head);
        System.out.println(res);
    }
}
