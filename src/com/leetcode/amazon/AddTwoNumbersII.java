package com.leetcode.amazon;

import com.leetcode.common.ListNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Stack;

// Amazon Top Questions
// tag: stack
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<Integer>();
        Stack<Integer> l2Stack = new Stack<Integer>();

        ListNode result = null;

        ListNode current = l1;
        while (current != null) {
            l1Stack.push(current.val);
            current = current.next;
        }
        current = l2;
        while (current != null) {
            l2Stack.push(current.val);
            current = current.next;
        }

        boolean addOne = false;
        while (l1Stack.size() > 0 && l2Stack.size() > 0) {
            int first = l1Stack.pop();
            int second = l2Stack.pop();
            int sum = addOne ? first + second + 1 : first + second;

            addOne = (sum >= 10) ? true : false;

            ListNode temp = new ListNode(sum % 10, result);
            result = temp;
        }

        while (l1Stack.size() > 0) {
            int first = l1Stack.pop();
            int sum = addOne ? first + 1 : first;

            addOne = (sum >= 10) ? true : false;

            ListNode temp = new ListNode(sum % 10, result);
            result = temp;
        }

        while (l2Stack.size() > 0) {
            int second = l2Stack.pop();
            int sum = addOne ? second + 1 : second;

            addOne = (sum >= 10) ? true : false;

            ListNode temp = new ListNode(sum % 10, result);
            result = temp;
        }

        if (addOne) {
            ListNode temp = new ListNode(1, result);
            result = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbersII test = new AddTwoNumbersII();

        // Example 1
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode actual = test.addTwoNumbers(l1, l2);

        // Example 2
        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        actual = test.addTwoNumbers(l1, l2);

        // Example 3
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        actual = test.addTwoNumbers(l1, l2);
    }
}
