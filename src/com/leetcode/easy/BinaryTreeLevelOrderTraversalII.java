package com.leetcode.easy;

import com.leetcode.common.TreeNode;
import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Binary Tree
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        traverse(root, map, 0);

        for (int i = map.size() - 1; i >= 0; i--) {
            result.add(map.get(i));
        }

        return result;
    }

    private void traverse(TreeNode current, Map<Integer, List<Integer>> map, int level) {
        if (current == null) return;

        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<Integer>());
        }

        map.get(level).add(current.val);

        traverse(current.left, map, level + 1);

        traverse(current.right, map, level + 1);
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII test = new BinaryTreeLevelOrderTraversalII();

        // Example
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(root);
        List<List<Integer>> result = test.levelOrderBottom(root);
        System.out.println("[");
        for (List<Integer> list : result) {
            Utils.printIntergerArray(list);
        }
        System.out.println("]");
    }
}
