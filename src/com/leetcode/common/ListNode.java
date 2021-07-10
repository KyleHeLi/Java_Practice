package com.leetcode.common;

import com.leetcode.easy.DeleteNodeInALinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int[] lst) {
        if (lst != null && lst.length != 0) {
            ListNode ptr = this;
            for (int i = 0, length = lst.length; i < length; i++) {
                ptr.val = lst[i];

                if (i + 1 < length) {
                    ptr.next = new ListNode();
                    ptr = ptr.next;
                }
            }
        }
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public boolean equals(ListNode other) {
        boolean result = true;

        ListNode ptr1 = this, pl2 = other;
        while (ptr1 != null && pl2 != null) {
            if (ptr1.val != pl2.val) {
                result = false;
                break;
            }

            ptr1 = ptr1.next;
            pl2 = pl2.next;
        }

        if ((ptr1 == null && pl2 != null) || (ptr1 != null && pl2 == null)) {
            result = false;
        }

        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(",");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
