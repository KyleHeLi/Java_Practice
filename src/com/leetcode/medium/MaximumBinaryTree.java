package com.leetcode.medium;

import com.leetcode.common.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0 , nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int low, int high) {
        if (nums == null || nums.length == 0 || low > high) {
            return null;
        }

        int ind = maxIndex(nums, low, high);

        TreeNode root = new TreeNode(nums[ind]);

        root.left = constructMaximumBinaryTree(nums, low, ind - 1);

        root.right = constructMaximumBinaryTree(nums, ind + 1, high);

        return root;
    }

    private int maxIndex(int[] nums, int low, int high) {
        int max = Integer.MIN_VALUE;
        int ind = low;
        for (int i = low; i <= high; i++) {
            if (max < nums[i]) {
                max = nums[i];
                ind = i;
            }
        }
        return ind;
    }

    public static void main(String[] args) {
        MaximumBinaryTree test = new MaximumBinaryTree();

        // Example 1
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode root = test.constructMaximumBinaryTree(nums);
        System.out.println(root);

        // Example 2
        nums = new int[]{3, 2, 1};
        root = test.constructMaximumBinaryTree(nums);
        System.out.println(root);
    }
}
