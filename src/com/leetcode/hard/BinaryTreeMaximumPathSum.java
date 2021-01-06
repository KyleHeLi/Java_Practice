package com.leetcode.hard;

import com.leetcode.common.TreeNode;

// Tag: Binary Search Tree
public class BinaryTreeMaximumPathSum {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;

        if (root == null) {
            return max;
        }

        oneSideMax(root);

        return max;
    }

    private int oneSideMax(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, oneSideMax(node.left));
        int right = Math.max(0, oneSideMax(node.right));

        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();

        // Example 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int t = test.maxPathSum(root);
        System.out.println(test.maxPathSum(root) == 6);

        // Example 2
        root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(test.maxPathSum(root) == 42);

        // Example 3
        root = new TreeNode(2);
        root.left = new TreeNode(-1);
        System.out.println(test.maxPathSum(root) == 2);
    }
}
