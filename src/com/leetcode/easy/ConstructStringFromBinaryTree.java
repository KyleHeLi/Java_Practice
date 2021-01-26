package com.leetcode.easy;

import com.leetcode.common.TreeNode;

// Binary Tree
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        sb.append(t.val);


        if (t.left == null && t.right == null) {
            return sb.toString();
        }


        sb.append("(");
        if (t.left != null) {
            sb.append(tree2str(t.left));
        }
        sb.append(")");

        if (t.right != null) {
            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ConstructStringFromBinaryTree test = new ConstructStringFromBinaryTree();

        // Example 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(root);
        String result = test.tree2str(root);
        System.out.println(result.equals("1(2(4))(3)"));

        // Example 2
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(root);
        result = test.tree2str(root);
        System.out.println(result.equals("1(2()(4))(3)"));
    }
}
