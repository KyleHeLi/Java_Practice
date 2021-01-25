package com.leetcode.easy;

import com.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIV_InputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        return findTarget(root, k, map);
    }

    private boolean findTarget(TreeNode node, int k, Map<Integer, Integer> map) {
        if (node == null) {
            return false;
        }

        if (!map.containsKey(k - node.val) && node.val != (k - node.val)) {
            map.put(k - node.val, node.val);
        }

        return findTarget(node.left, k, map) || map.containsKey(node.val) || findTarget(node.right, k, map);
    }

    public static void main(String[] args) {
        TwoSumIV_InputIsABST test = new TwoSumIV_InputIsABST();

        // Example 1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        int k = 9;
        boolean result = test.findTarget(root, k);
        System.out.println(result == true);

        // Example 2
        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        k = 28;
        result = test.findTarget(root, k);
        System.out.println(result == false);

        // Example 3
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        k = 4;
        result = test.findTarget(root, k);
        System.out.println(result == true);

        // Example 4
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        k = 1;
        result = test.findTarget(root, k);
        System.out.println(result == false);

        // Example 5
        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        k = 3;
        result = test.findTarget(root, k);
        System.out.println(result == true);

        // Example 6
        root = new TreeNode(1);
        k = 2;
        result = test.findTarget(root, k);
        System.out.println(result == false);
    }
}
