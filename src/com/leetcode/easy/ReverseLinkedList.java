package com.leetcode.easy;

import com.leetcode.common.ListNode;

import java.util.Stack;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode nxt = null;

        while (head != null) {
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }

//    public ListNode reverseList(ListNode head) {
//        ListNode reverse = null;
//        Stack<Integer> stack = new Stack<Integer>();
//
//        if (head != null) {
//            ListNode current = head;
//            while (current != null) {
//                stack.push(current.val);
//                current = current.next;
//            }
//
//            while (!stack.isEmpty()) {
//                if (reverse == null) {
//                    reverse = new ListNode(stack.pop());
//                    current = reverse;
//                } else {
//                    current.next = new ListNode(stack.pop());
//                    current = current.next;
//                }
//            }
//        }
//
//        return reverse;
//    }

    public static void main(String[] args) {
        ReverseLinkedList test = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(test.reverseList(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(test.reverseList(head));

        head = null;
        System.out.println(test.reverseList(head));
    }
}
