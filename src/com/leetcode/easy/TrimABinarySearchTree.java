package com.leetcode.easy;

import com.leetcode.common.TreeNode;

import java.util.List;

public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        if (root.val < low) {
            return root.right;
        }

        if (root.val > high) {
            return root.left;
        }

        return root;
    }

    public static void main(String[] args) {
        TrimABinarySearchTree test = new TrimABinarySearchTree();

        // Example 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        int low = 1;
        int high = 2;
        TreeNode result = test.trimBST(root, low, high);
        System.out.println(result);

        // Example 2
        root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        low = 1;
        high = 3;
        result = test.trimBST(root, low, high);
        System.out.println(result);

        // Example 3
        root = new TreeNode(1);
        low = 1;
        high = 2;
        result = test.trimBST(root, low, high);
        System.out.println(result);

        // Example 4
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        low = 1;
        high = 3;
        result = test.trimBST(root, low, high);
        System.out.println(result);

        // Example 5
        root = new TreeNode(1);
        root.right = new TreeNode(2);
        low = 2;
        high = 4;
        result = test.trimBST(root, low, high);
        System.out.println(result);

        // Example 6
        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        low = 3;
        high = 4;
        result = test.trimBST(root, low, high);
        System.out.println(result);
    }
}
