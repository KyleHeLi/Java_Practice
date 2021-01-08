package com.leetcode.easy;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<TreeNode> nodes = new ArrayList<TreeNode>();

        inorderTraversal(nodes, root);

        TreeNode newRoot = nodes.get(0);
        TreeNode current = newRoot;

        for (int i = 1; i < nodes.size(); i++) {
            current.right = nodes.get(i);
            current = current.right;
        }

        return newRoot;
    }

    private void inorderTraversal(List<TreeNode> nodes, TreeNode node) {
        if (nodes == null || node == null) {
            return;
        }

        inorderTraversal(nodes, node.left);

        nodes.add(new TreeNode(node.val));

        inorderTraversal(nodes, node.right);
    }

    public static void main(String[] args) {
        IncreasingOrderSearchTree test = new IncreasingOrderSearchTree();

        // Example 1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        System.out.println(root);
        TreeNode e1 = test.increasingBST(root);
        System.out.println(e1);

        // Example 2
        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        System.out.println(root);
        TreeNode e2 = test.increasingBST(root);
        System.out.println(e2);
    }
}
