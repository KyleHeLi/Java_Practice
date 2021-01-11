package com.leetcode.medium;

import com.leetcode.common.ListNode;
import com.leetcode.common.TreeNode;

public class ConvertedSortedListToBinarySearchTree {

//    public TreeNode sortedListToBST(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//
//        int[] a = new int[size(head)];
//        ListNode current = head;
//        for (int i = 0; i < a.length; i++) {
//            a[i] = current.val;
//            current = current.next;
//        }
//
//        return sortedListToBST(a, 0, a.length - 1);
//    }
//
//    private TreeNode sortedListToBST(int[] head, int start, int end) {
//        if (start > end) {
//            return null;
//        }
//
//        int mid = (start + end + 1) / 2;
//
//
//        TreeNode root = new TreeNode(head[mid]);
//
//        root.left = sortedListToBST(head, start, mid - 1);
//
//        root.right = sortedListToBST(head, mid + 1, end);
//
//        return root;
//    }
//
//    private int size(ListNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        return 1 + size(root.next);
//    }

    // better solution
    public TreeNode sortedListToBST(ListNode head) {
        // 1st base case: return null if there are no nodes in ListNode
        if(head == null) {
            return null;
        }

        // 2nd base case: return a new TreeNode if there is one node in ListNode
        if(head.next == null) {
            return new TreeNode(head.val);
        }

        // Otherwise, start searching for the middle node using slow and fast pointers
        ListNode slow = head; // Act as middle node
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reuse the fast pointer to divide the ListNode into two halves
        fast = head;
        while(fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;

        // Create the node that will be returned using the value of the middle node
        TreeNode root = new TreeNode(slow.val);

        // Recursively call the function for the first half
        // That will be our left sub-tree
        root.left = sortedListToBST(head);

        // Recursively call the function for the second half
        // That will be our right sub-tree
        root.right = sortedListToBST(slow.next);

        // Return the middle node
        return root;
    }

    public static void main(String[] args) {
        ConvertedSortedListToBinarySearchTree test = new ConvertedSortedListToBinarySearchTree();

        // Example 1
        int[] head = new int[]{-10, -3, 0, 5, 9};
        ListNode root = new ListNode(head[0]), current = null;
        for (int i = 1; i < head.length; i++, current = current.next) {
            current = (current == null) ? root : current;
            current.next = new ListNode(head[i]);
        }
        TreeNode t = test.sortedListToBST(root);
        System.out.println(t);

        // Example 2
        head = new int[]{};
        root = null;
        current = null;
        for (int i = 1; i < head.length; i++, current = current.next) {
            current = (current == null) ? root : current;
            current.next = new ListNode(head[i]);
        }
        System.out.println(test.sortedListToBST(root));

        // Example 3
        head = new int[]{0};
        root = new ListNode(head[0]);
        current = null;
        for (int i = 1; i < head.length; i++, current = current.next) {
            current = (current == null) ? root : current;
            current.next = new ListNode(head[i]);
        }
        System.out.println(test.sortedListToBST(root));

        // Example 4
        head = new int[]{1, 3};
        root = new ListNode(head[0]);
        current = null;
        for (int i = 1; i < head.length; i++, current = current.next) {
            current = (current == null) ? root : current;
            current.next = new ListNode(head[i]);
        }
        System.out.println(test.sortedListToBST(root));
    }
}
