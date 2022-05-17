package com.leetcode.medium;

import com.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> head = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] description : descriptions) {
            head.add(description[0]);
            TreeNode parent = map.getOrDefault(description[0], new TreeNode(description[0]));
            TreeNode child = map.getOrDefault(description[1], new TreeNode(description[1]));
            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            map.put(parent.val, parent);
            map.put(child.val, child);
        }

        for (int[] description : descriptions)
            head.remove(description[1]);

        return map.get(head.iterator().next());
    }

    public static void main(String[] args) {
        CreateBinaryTreeFromDescriptions test = new CreateBinaryTreeFromDescriptions();

        // Example 1
        int[][] descriptions = new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        TreeNode res = test.createBinaryTree(descriptions);
        System.out.println(res);

        // Example 2
        descriptions = new int[][]{{1, 2, 1}, {2, 3, 0}, {3, 4, 1}};
        res = test.createBinaryTree(descriptions);
        System.out.println(res);
    }
}
