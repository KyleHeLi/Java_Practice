package com.leetcode.easy;

import com.leetcode.common.ListNode;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode current = root;

        ListNode ptr1 = l1, ptr2 = l2;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                if (root == null) {
                    root = new ListNode(ptr1.val);
                    current = root;
                } else {
                    current.next = new ListNode(ptr1.val);
                }

                ptr1 = ptr1.next;
            } else {
                if (root == null) {
                    root = new ListNode(ptr2.val);
                    current = root;
                } else {
                    current.next = new ListNode(ptr2.val);
                }

                ptr2 = ptr2.next;
            }

            if (current.next != null)  current = current.next;
        }

        while (ptr1 != null) {
            if (root == null) {
                root = new ListNode(ptr1.val);
                current = root;
            } else {
                current.next = new ListNode(ptr1.val);
                current = current.next;
            }
            ptr1 = ptr1.next;
        }

        while (ptr2 != null) {
            if (root == null) {
                root = new ListNode(ptr2.val);
                current = root;
            } else {
                current.next = new ListNode(ptr2.val);
                current = current.next;
            }
            ptr2 = ptr2.next;
        }

        return root;
    }

    public static void main(String[] args) {
        MergeTwoSortedList test = new MergeTwoSortedList();

        // Example 1
        ListNode l1 = new ListNode(new int[]{1, 2, 4});
        ListNode l2 = new ListNode(new int[]{1, 3, 4});
        ListNode result = test.mergeTwoLists(l1, l2);
        System.out.println(result.equals(new ListNode(new int[]{1, 1, 2, 3, 4, 4})));

        // Example 2
        l1 = null;
        l2 = null;
        result = test.mergeTwoLists(l1, l2);
        System.out.println(result == null);

        // Example 3
        l1 = null;
        l2 = new ListNode(new int[]{0});
        result = test.mergeTwoLists(l1, l2);
        System.out.println(result.equals(new ListNode(new int[]{0})));

        // Example 4
        l1 = new ListNode(new int[]{2});
        l2 = new ListNode(new int[]{1});
        result = test.mergeTwoLists(l1, l2);
        System.out.println(result.equals(new ListNode(new int[]{1, 2})));
    }
}
