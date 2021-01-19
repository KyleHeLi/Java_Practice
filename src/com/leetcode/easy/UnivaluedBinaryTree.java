package com.leetcode.easy;

import com.leetcode.common.TreeNode;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode node, int val) {
        if (node == null) {
            return true;
        }

        return node.val == val && isUnivalTree(node.left, val) && isUnivalTree(node.right, val);
    }

    public static void main(String[] args) {
        UnivaluedBinaryTree test = new UnivaluedBinaryTree();

        // Example 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(root);
        boolean result = test.isUnivalTree(root);
        System.out.println(result == true);

        // Example 2
        root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        System.out.println(root);
        result = test.isUnivalTree(root);
        System.out.println(result == false);
    }
}
