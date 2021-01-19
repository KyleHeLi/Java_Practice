package com.leetcode.easy;

import com.leetcode.common.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode current = root;

        TreeNode right = invertTree(current.left);
        TreeNode left = invertTree(current.right);

        current.left = left;
        current.right = right;

        return current;
    }

    public static void main(String[] args) {
        InvertBinaryTree test = new InvertBinaryTree();

        // Example
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(root);
        TreeNode result = test.invertTree(root);
        System.out.println(result);
    }
}
