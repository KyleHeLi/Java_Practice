package com.leetcode.medium;

import com.leetcode.common.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderandPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTreeFromInPost(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode constructTreeFromInPost(int[] inorder, int[] postorder, int start, int end, int index) {
        if (start > end) return null;
        TreeNode root = new TreeNode(postorder[index]);

        int inRootIndex = start;
        while(postorder[index] != inorder[inRootIndex]) inRootIndex++;

        root.right = constructTreeFromInPost(inorder, postorder, inRootIndex + 1, end, index - 1);
        root.left = constructTreeFromInPost(inorder, postorder, start, inRootIndex - 1, index - (end - inRootIndex) - 1);

        return root;
    }

//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
//            return null;
//        }
//
//        int i = 0;
//        while (i < inorder.length && inorder[i] == postorder[i]) {
//            i++;
//        }
//
//        if (i >= inorder.length) {
//            i = inorder.length - 1;
//        }
//
//        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
//
//        if (i >= 1) {
//            root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
//        }
//
//        if (i + 1 <= inorder.length) {
//            root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
//        }
//
//        return root;
//    }


    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderandPostorderTraversal test = new ConstructBinaryTreeFromInorderandPostorderTraversal();

        // Example 1
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = test.buildTree(inorder, postorder);
        System.out.println(root);

        // Example 2
        inorder = new int[]{2,3,1};
        postorder = new int[]{3,2,1};
        root = test.buildTree(inorder, postorder);
        System.out.println(root);
    }
}
