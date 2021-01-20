package com.leetcode.easy;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<Integer>();
        List<Integer> r2 = new ArrayList<Integer>();

        traverse(root1, r1);
        traverse(root2, r2);

        if (r1.size() != r2.size()) {
            return false;
        }

        boolean result = true;
        for (int i = 0; i < r1.size(); i++) {
            if (r1.get(i) != r2.get(i)) {
                result = false;
                break;
            }
        }

        return result;
    }

    private void traverse(TreeNode node, List<Integer> leafs) {
        if (node == null) {
            return;
        }

        traverse(node.left, leafs);

        traverse(node.right, leafs);

        if (node.left == null && node.right == null) {
            leafs.add(node.val);
        }
    }

    public static void main(String[] args) {
        LeafSimilarTrees test = new LeafSimilarTrees();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);
        boolean result = test.leafSimilar(root1, root2);
        System.out.println(result == true);

        // Example 2
        root1 = new TreeNode(1);
        root2 = new TreeNode(1);
        result = test.leafSimilar(root1, root2);
        System.out.println(result == true);

        // Example 3
        root1 = new TreeNode(1);
        root2 = new TreeNode(2);
        result = test.leafSimilar(root1, root2);
        System.out.println(result == false);

        // Example 4
        root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        result = test.leafSimilar(root1, root2);
        System.out.println(result == true);

        // Example 5
        root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        result = test.leafSimilar(root1, root2);
        System.out.println(result == false);
    }
}
