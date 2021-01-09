package com.leetcode.medium;

import com.leetcode.common.TreeNode;
import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        postorderTraversal(root, result);

        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left, result);

        postorderTraversal(root.right, result);

        result.add(root.val);
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal test = new BinaryTreePostorderTraversal();

        // Example 1
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Utils.printIntergerArray(test.postorderTraversal(root));

        // Example 2
        root = null;
        Utils.printIntergerArray(test.postorderTraversal(root));

        // Example 3
        root = new TreeNode(1);
        Utils.printIntergerArray(test.postorderTraversal(root));
    }
}
