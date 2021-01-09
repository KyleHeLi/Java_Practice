package com.leetcode.hard;

import com.leetcode.common.TreeNode;

public class RecoverBinarySearchTree {
    TreeNode prev;
    TreeNode nodeToSwitch1;
    TreeNode nodeToSwitch2;

    public void recoverTree(TreeNode root) {
        prev = null;
        nodeToSwitch1 = null;
        nodeToSwitch2 = null;

        traverse(root);

        int temp = nodeToSwitch1.val;
        nodeToSwitch1.val = nodeToSwitch2.val;
        nodeToSwitch2.val = temp;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        traverse(node.left);

        if (prev != null && node.val < prev.val) {
            nodeToSwitch1 = (nodeToSwitch1 == null) ? prev : nodeToSwitch1;
            nodeToSwitch2 = node;
        }

        prev = node;

        traverse(node.right);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree test = new RecoverBinarySearchTree();

        // Example 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        System.out.println(root);
        test.recoverTree(root);
        System.out.println(root);

        // Example 2
        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        System.out.println(root);
        test.recoverTree(root);
        System.out.println(root);
    }
}
