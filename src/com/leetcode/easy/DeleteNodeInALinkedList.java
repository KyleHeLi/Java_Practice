package com.leetcode.easy;

import com.leetcode.common.ListNode;

public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        ListNode current = node;
        ListNode previous = current;
        while (current.next != null) {
            current.val = current.next.val;
            previous = current;
            current = current.next;
        }
        previous.next = null;
    }

    public static void main(String[] args) {
        DeleteNodeInALinkedList test = new DeleteNodeInALinkedList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        ListNode delete = head.next;
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        test.deleteNode(delete);
        System.out.println(head);

        head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        delete = head.next.next;
        head.next.next.next = new ListNode(9);
        test.deleteNode(delete);
        System.out.println(head);
    }
}
