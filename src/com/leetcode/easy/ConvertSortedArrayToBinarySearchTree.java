package com.leetcode.easy;

import com.leetcode.common.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, low, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, high);

        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree test = new ConvertSortedArrayToBinarySearchTree();

        // Example
        int[] nums = new int[] {-10, -3, 0, 5, 9};
        TreeNode result = test.sortedArrayToBST(nums);
        System.out.println(result);
    }
}
