package com.leetcode.easy;

import com.leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class SumOfRootToLeafBinaryNumbers {
    // better solution
    private static int result = 0;

    public int sumRootToLeaf(TreeNode root) {
        result = 0;
        traverse(root, 0);
        return result;
    }

    private static void traverse(TreeNode node, int sum) {
        if (node == null) {
            return;
        }

        sum = sum * 2 + node.val;

        if (node.left == null && node.right == null) {
            result += sum;
        }

        traverse(node.left, sum);

        traverse(node.right, sum);
    }

//    public int sumRootToLeaf(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        List<String> result = new ArrayList<String>();
//
//        traverse(root, "", result);
//
//        int sum = 0;
//        for (String path : result) {
//            for (int i = path.length() - 1, j = 0; i >= 0; i--, j++) {
//                int value = path.charAt(i) - 48;
//                sum += value * Math.pow(2, j);
//            }
//        }
//
//        return sum;
//    }
//
//    private void traverse(TreeNode node, String path, List<String> pathSum) {
//        if (node == null) {
//            return;
//        }
//
//        String a = path + node.val;
//
//        if (node.left == null && node.right == null) {
//            pathSum.add(a);
//        }
//
//        traverse(node.left, a, pathSum);
//
//        traverse(node.right, a, pathSum);
//    }

    public static void main(String[] args) {
        SumOfRootToLeafBinaryNumbers test = new SumOfRootToLeafBinaryNumbers();

        // Example 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        int result = test.sumRootToLeaf(root);
        System.out.println(result == 22);

        // Example 2
        root = new TreeNode(0);
        result = test.sumRootToLeaf(root);
        System.out.println(result == 0);

        // Example 3
        root = new TreeNode(1);
        result = test.sumRootToLeaf(root);
        System.out.println(result == 1);

        // Example 4
        root = new TreeNode(1);
        root.left = new TreeNode(1);
        result = test.sumRootToLeaf(root);
        System.out.println(result == 3);
    }
}
