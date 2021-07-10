package com.leetcode.amazon;

import com.leetcode.common.TreeNode;

// Top Amazon Questions
public class SubtreeOfAnotherTree {

    // Preorder traverse
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null) {
            return false;
        } else {
            if (isEqualTree(root, subRoot)) {
                return true;
            } else {
                return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
            }
        }
    }

    private boolean isEqualTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        } else {
            if (root.val == subRoot.val) {
                return (isEqualTree(root.left, subRoot.left) && isEqualTree(root.right, subRoot.right));
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree test = new SubtreeOfAnotherTree();

        // Example 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        boolean result = test.isSubtree(root, subRoot);
        System.out.println(result == true);

        // Example 2
        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);

        subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        result = test.isSubtree(root, subRoot);
        System.out.println(result == false);

        // Example 3
        root = new TreeNode(1);
        root.left = new TreeNode(1);

        subRoot = new TreeNode(1);

        result = test.isSubtree(root, subRoot);
        System.out.println(result == true);
    }
}
