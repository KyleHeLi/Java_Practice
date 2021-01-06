package com.leetcode.medium;


import com.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

// Tag: Binary Search Tree
public class ValidateBinarySearchTree {
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        boolean leftValid = isValidBST(root.left);
//
//        boolean midValid = true;
//
//        if (root.left != null) {
//            midValid = midValid && (root.left.val < root.val);
//        }
//
//        if (root.right != null) {
//            midValid = midValid && (root.right.val > root.val);
//        }
//
//        boolean rightValid = isValidBST(root.right);
//
//        return leftValid && midValid && rightValid;
//    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> sequence = new ArrayList<Integer>();

        inorderTraversal(root, sequence);

        int pre = sequence.get(0);

        for (int i = 1, length = sequence.size(); i < length; i++) {
            if (pre >= sequence.get(i)) {
                return false;
            } else {
                pre = sequence.get(i);
            }
        }

        return true;
    }

    private void inorderTraversal(TreeNode node, List<Integer> sequence) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, sequence);

        sequence.add(node.val);

        inorderTraversal(node.right, sequence);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree test = new ValidateBinarySearchTree();

        // Example 1
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(test.isValidBST(root) == true);

        // Example 2
        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(test.isValidBST(root) == false);

        // Example 3
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(test.isValidBST(root) == false);
    }
}
