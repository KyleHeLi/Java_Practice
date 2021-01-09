package com.leetcode.medium;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepestLeavesSum {

    private int maxDepth;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxDepth = 0;
        Map<Integer, Integer> records = new HashMap<Integer, Integer>();

        onePathSum(records, root, 0);

        return records.get(maxDepth);
    }

    private void onePathSum(Map<Integer, Integer> records, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (!records.containsKey(level)) {
            records.put(level, 0);
        }

        records.put(level, records.get(level) + node.val);

        if (level > maxDepth) {
            maxDepth = level;
        }

        onePathSum(records, node.left, level + 1);

        onePathSum(records, node.right, level + 1);
    }

    public static void main(String[] args) {
        DeepestLeavesSum test = new DeepestLeavesSum();

        // Example
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        System.out.println(root);
        int result = test.deepestLeavesSum(root);
        System.out.println(result == 15);

    }
}
