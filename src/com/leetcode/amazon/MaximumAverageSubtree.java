package com.leetcode.amazon;

import com.leetcode.common.TreeNode;

// Top Amazon Questions
// tag: tree traversal, post-order
public class MaximumAverageSubtree {

    // t -> O(n), s -> O(n)
    double max;

    public double maximumAverageSubtree(TreeNode root) {
        max = 0;

        traverse(root, 0);

        return max;
    }

    private double[] traverse(TreeNode root, int count) {
        if (root == null) {
            return new double[]{0, 0};
        }

        double[] right = traverse(root.left, count + 1);

        double[] left = traverse(root.right, count + 1);

        double sum = root.val + right[0] + left[0];

        double num = 1 + right[1] + left[1];

        max = max < sum / num ? sum / num : max;

        return new double[]{sum, num};
    }

    public static void main(String[] args) {
        MaximumAverageSubtree test = new MaximumAverageSubtree();

        // Example 1
        TreeNode root = new TreeNode(5, new TreeNode(6), new TreeNode(1));
        double expected = 6;
        double actual = test.maximumAverageSubtree(root);
        System.out.println(expected == actual);
    }
}
