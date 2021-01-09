package com.leetcode.easy;

import com.leetcode.common.TreeNode;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode newRoot = root;

        if (val < root.val) {
            newRoot = searchBST(root.left, val);
        } else if (val > root.val) {
            newRoot = searchBST(root.right, val);
        }

        return newRoot;
    }


    public static void main(String[] args) {
        SearchInABinarySearchTree test = new SearchInABinarySearchTree();

        // Example
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode t = test.searchBST(root, 2);
        System.out.println(t);
    }
}
