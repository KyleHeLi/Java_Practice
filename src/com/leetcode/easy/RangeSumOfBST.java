package com.leetcode.easy;

import com.leetcode.common.TreeNode;

// Tag: Binary Search Tree
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }

        if (root.val < low) {
           return rangeSumBST(root.right, low, high);
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val;
    }

    public static void main(String[] args) {
        RangeSumOfBST test = new RangeSumOfBST();

        // Example 1
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(test.rangeSumBST(root, 7, 15));
        System.out.println(test.rangeSumBST(root, 7, 15) == 32);

        // Example 2
        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        System.out.println(test.rangeSumBST(root, 6, 10));
        System.out.println(test.rangeSumBST(root, 6, 10) == 23);
    }
}
