package com.leetcode.easy;

import com.leetcode.common.TreeNode;
import com.leetcode.common.Utils;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Tag: Binary Tree
public class SymmetricTree {
    // Better solution
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null) {
            return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }

        return false;
    }

//    public boolean isSymmetric(TreeNode root) {
//        List<Integer> t1 = new ArrayList<Integer>();
//        List<Integer> t2 = new ArrayList<Integer>();
//
//        preorderTraversal(root, t1);
//        reversePreorderTraversal(root, t2);
//
//        boolean result = true;
//
//        if (t1.size() != t2.size()) {
//            result = false;
//        } else {
//            for (int i = 0, length = t1.size(); i < length; i++) {
//                if (!t1.get(i).equals(t2.get(i))) {
//                    result = false;
//                    break;
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private void preorderTraversal(TreeNode node, List<Integer> sequence) {
//        if (node == null) {
//            sequence.add(Integer.MIN_VALUE);
//            return;
//        }
//
//        if (node.left == null && node.right == null) {
//            sequence.add(node.val);
//            return;
//        }
//
//        sequence.add(node.val);
//
//        preorderTraversal(node.left, sequence);
//
//        preorderTraversal(node.right, sequence);
//    }
//
//    private void reversePreorderTraversal(TreeNode node, List<Integer> sequence) {
//        if (node == null) {
//            sequence.add(Integer.MIN_VALUE);
//            return;
//        }
//
//        if (node.left == null && node.right == null) {
//            sequence.add(node.val);
//            return;
//        }
//
//        sequence.add(node.val);
//
//        reversePreorderTraversal(node.right, sequence);
//
//        reversePreorderTraversal(node.left, sequence);
//    }

    public static void main(String[] args) {
        SymmetricTree test = new SymmetricTree();

        // Example 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(test.isSymmetric(root) == true);

        // Example 2
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        System.out.println(test.isSymmetric(root) == false);

        // Example 3
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(test.isSymmetric(root) == false);

        // Example 4
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(2);
        System.out.println(test.isSymmetric(root) == false);

        // Example 5
        root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.right.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right.right.left.left = new TreeNode(6);

        root.left.left.right.right.left = new TreeNode(7);
        root.left.left.right.right.right = new TreeNode(8);
        root.right.right.left.left.left = new TreeNode(8);
        root.right.right.left.left.right = new TreeNode(7);

        root.left.left.right.right.left.left = new TreeNode(9);
        root.left.left.right.right.left.right = new TreeNode(0);
        root.left.left.right.right.right.left = new TreeNode(0);
        root.left.left.right.right.right.right = new TreeNode(1);

        root.right.right.left.left.left.left = new TreeNode(1);
        root.right.right.left.left.left.right = new TreeNode(0);
        root.right.right.left.left.right.left = new TreeNode(0);
        root.right.right.left.left.right.right = new TreeNode(9);
        System.out.println(test.isSymmetric(root) == true);
    }
}
