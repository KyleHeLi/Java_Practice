package com.leetcode.easy;

import com.leetcode.common.Node;
import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepthOfN_aryTree {
    public int maxDepth(Node root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(Node node, int sum) {
        if (node == null) {
            return 0;
        }

        if (node.children == null || node.children.size() == 0) {
            return sum + 1;
        }

        int max = 0;
        for (Node child : node.children) {
            int tmp = maxDepth(child, sum + 1);
            if (tmp > max) {
                max = tmp;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumDepthOfN_aryTree test = new MaximumDepthOfN_aryTree();

        // Example 1
        Node root = new Node(1);
        List<Node> level1 = new ArrayList<Node>();
        level1.add(new Node(3));
        level1.add(new Node(2));
        level1.add(new Node(4));
        root.children = level1;
        List<Node> level2 = new ArrayList<Node>();
        level2.add(new Node(5));
        level2.add(new Node(6));
        level1.get(0).children = level2;
        System.out.println(root);
        int result = test.maxDepth(root);
        System.out.println(result == 3);
    }
}
