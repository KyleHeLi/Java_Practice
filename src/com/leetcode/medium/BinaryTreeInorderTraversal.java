package com.leetcode.medium;

import com.leetcode.common.TreeNode;
import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        inorderTraversal(root, result);

        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, result);

        result.add(root.val);

        inorderTraversal(root.right, result);
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();

        // Example 1
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Utils.printIntergerArray(test.inorderTraversal(root));

        // Example 2
        root = null;
        Utils.printIntergerArray(test.inorderTraversal(root));

        // Example 3
        root = new TreeNode(1);
        Utils.printIntergerArray(test.inorderTraversal(root));
    }
}
