package com.leetcode.easy;

import com.leetcode.common.TreeNode;
import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.List;

// Tag: Binary Search Tree
public class BinaryTreePaths {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }

        return binaryTreePaths(root, new String(""));
    }

    private List<String> binaryTreePaths(TreeNode node, String path) {
        List<String> newPaths = new ArrayList<String>();

        if (node == null) {
            return newPaths;
        }

        String p = path.equals("") ? String.valueOf(node.val) : path + "->" + node.val;

        List<String> left = new ArrayList<String>();
        List<String> right = new ArrayList<String>();

        if (node.left != null) {
            left = binaryTreePaths(node.left, p);
        }

        if (node.right != null) {
            right = binaryTreePaths(node.right, p);
        }

        if (node.left == null && node.right == null) {
            newPaths.add(p);
        }

        newPaths.addAll(left);
        newPaths.addAll(right);

        return newPaths;
    }

    public static void main(String[] args) {
        BinaryTreePaths test = new BinaryTreePaths();

        // Example
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        Utils.printStringArray(test.binaryTreePaths(root));
    }
}
