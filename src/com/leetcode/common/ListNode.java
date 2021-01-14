package com.leetcode.common;

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

        ListNode ptr1 = this, ptr2 = other;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val != ptr2.val) {
                result = false;
                break;
            }

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        if ((ptr1 == null && ptr2 != null) || (ptr1 != null && ptr2 == null)) {
            result = false;
        }

        return result;
    }
}
