package com.leetcode.medium;

import com.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {

    // better solution
    TreeNode answer = new TreeNode();
    TreeNode head = null;
    public void flatten(TreeNode root) {
        if(root != null) {
            answer.val = root.val;
            head = answer;

            flattenBinaryTree(root);

            root.left = null;
            root.right = answer.right;
        }
    }

    void flattenBinaryTree(TreeNode root) {
        if(root == null) {return;}

        if(root.left != null) {
            head.right = new TreeNode(root.left.val);
            head = head.right;
            flattenBinaryTree(root.left);
        }

        if(root.right != null) {
            head.right = new TreeNode(root.right.val);
            head = head.right;
            flattenBinaryTree(root.right);
        }
    }

//    public void flatten(TreeNode root) {
//        List<TreeNode> nodes = new LinkedList<TreeNode>();
//
//        traverse(root, nodes);
//
//        if (nodes.size() > 0) {
//            TreeNode current = nodes.get(0);
//
//            for (int i = 1, length = nodes.size(); i < length; i++) {
//                current.left = null;
//                current.right = nodes.get(i);
//                current = current.right;
//            }
//        }
//    }
//
//    private void traverse(TreeNode node, List<TreeNode> preorder) {
//        if (node == null || preorder == null) {
//            return;
//        }
//
//        preorder.add(node);
//
//        traverse(node.left, preorder);
//
//        traverse(node.right, preorder);
//    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();

        // Example
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        System.out.println(root);
        test.flatten(root);
        System.out.println(root);
    }

}
