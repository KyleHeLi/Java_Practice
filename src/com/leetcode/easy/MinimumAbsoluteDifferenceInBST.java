package com.leetcode.easy;

import com.leetcode.common.TreeNode;

import java.util.List;

// Binary Tree
public class MinimumAbsoluteDifferenceInBST {

    TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        pre = null;
        return getMinimumDifference(root, Integer.MAX_VALUE);
    }

    private int getMinimumDifference(TreeNode root, int diff) {
        if (root == null) {
            return diff;
        }

        int min = getMinimumDifference(root.left, diff);

        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;

        min = Math.min(min, getMinimumDifference(root.right, min));

        return min;

    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST test = new MinimumAbsoluteDifferenceInBST();

        // Example
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(root);
        int result = test.getMinimumDifference(root);
        System.out.println(result == 1);
    }
}
