package com.leetcode.medium;

import com.leetcode.common.TreeNode;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || cloned == null || target == null) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }

        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if (right != null) {
            return right;
        }

        return null;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree test = new FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree();

        // Example 1
        TreeNode original = new TreeNode(7);
        original.left = new TreeNode(4);
        original.right = new TreeNode(3);
        original.right.left = new TreeNode(6);
        original.right.right = new TreeNode(19);
        TreeNode target = original.right;
        TreeNode cloned = (TreeNode) original.clone();
        TreeNode result = test.getTargetCopy(original, cloned, target);
        System.out.println(result);

        // Example 2
        original = new TreeNode(7);
        target = original;
        cloned = (TreeNode) original.clone();
        result = test.getTargetCopy(original, cloned, target);
        System.out.println(result);

        // Example 3
        original = new TreeNode(8);
        original.right = new TreeNode(6);
        original.right.right = new TreeNode(5);
        original.right.right.right = new TreeNode(4);
        original.right.right.right.right = new TreeNode(3);
        original.right.right.right.right.right = new TreeNode(2);
        original.right.right.right.right.right.right = new TreeNode(1);
        target = original.right.right.right;
        cloned = (TreeNode) original.clone();
        result = test.getTargetCopy(original, cloned, target);
        System.out.println(result);

        // Example 4
        original = new TreeNode(1);
        original.left = new TreeNode(2);
        original.left.left = new TreeNode(4);
        original.left.right = new TreeNode(5);
        original.left.left.left = new TreeNode(8);
        original.left.left.right = new TreeNode(9);
        original.right = new TreeNode(3);
        original.right.left = new TreeNode(6);
        original.right.right = new TreeNode(7);
        target = original.right.right.right;
        cloned = (TreeNode) original.clone();
        result = test.getTargetCopy(original, cloned, target);
        System.out.println(result);

        // Example 4
        original = new TreeNode(1);
        original.left = new TreeNode(2);
        original.left.left = new TreeNode(3);
        target = original.left;
        cloned = (TreeNode) original.clone();
        result = test.getTargetCopy(original, cloned, target);
        System.out.println(result);
    }
}
