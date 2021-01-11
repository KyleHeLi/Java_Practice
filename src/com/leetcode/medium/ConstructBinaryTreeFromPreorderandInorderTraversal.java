package com.leetcode.medium;

import com.leetcode.common.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int i = 0;
        while (preorder[0] != inorder[i]) {
            i++;
        }

        if (i >= 0) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        }

        if (i + 1 <= preorder.length) {
            root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
        }

        return root;
    }


    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderandInorderTraversal test = new ConstructBinaryTreeFromPreorderandInorderTraversal();

        // Example
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = test.buildTree(preorder, inorder);
        System.out.println(root);
    }
}
