package com.leetcode.medium;

import com.leetcode.common.TreeNode;
import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SumOfNodesWithEvenValuedGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();

        traverse(root, nodes);

        int sum = 0;

        for (TreeNode node : nodes) {
            if (node.left != null) {
                if (node.left.left != null) {
                    sum += node.left.left.val;
                }

                if (node.left.right != null) {
                    sum += node.left.right.val;
                }
            }

            if (node.right != null) {
                if (node.right.left != null) {
                    sum += node.right.left.val;
                }

                if (node.right.right != null) {
                    sum += node.right.right.val;
                }
            }
        }

        return sum;
    }

    private void traverse(TreeNode node, List<TreeNode> evenNodes) {
        if (node == null) return;

        if (node.val % 2 == 0) {
            evenNodes.add(node);
        }

        traverse(node.left, evenNodes);

        traverse(node.right, evenNodes);
    }

    public static void main(String[] args) {
        SumOfNodesWithEvenValuedGrandparent test = new SumOfNodesWithEvenValuedGrandparent();

        // Example
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(root);
        int result = test.sumEvenGrandparent(root);
        System.out.println(result == 18);
    }
}
