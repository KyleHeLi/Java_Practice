package com.leetcode.easy;

import com.leetcode.common.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree test = new MaximumDepthOfBinaryTree();

        // Example 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(root);
        int result = test.maxDepth(root);
        System.out.println(result == 3);

        // Example 2
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        result = test.maxDepth(root);
        System.out.println(result == 2);

        // Example 3
        root = null;
        result = test.maxDepth(root);
        System.out.println(result == 0);
    }
}
