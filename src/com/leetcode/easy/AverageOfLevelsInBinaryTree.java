package com.leetcode.easy;

import com.leetcode.common.TreeNode;
import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<Double>();
        }

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        traverse(root, map, 0);

        List<Double> result = new ArrayList<Double>();

        for (int i = 0; i < map.size(); i++) {
            List<Integer> tmp = map.get(i);
            double sum = 0;
            for (int val : tmp) {
                sum += val;
            }

            result.add(sum / tmp.size());
        }

        return result;
    }

    private void traverse(TreeNode node, Map<Integer, List<Integer>> map, int level) {
        if (node == null) return;

        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<Integer>());
        }

        map.get(level).add(node.val);

        traverse(node.left, map, level + 1);

        traverse(node.right, map, level + 1);
    }

    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree test = new AverageOfLevelsInBinaryTree();

        // Example
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(root);
        List<Double> result = test.averageOfLevels(root);
        Utils.printDoubleArray(result);
    }
}
