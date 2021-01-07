package com.leetcode.easy;

import com.leetcode.common.TreeNode;

// Tag: Binary Tree
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        boolean same = p.val == q.val;

        return isSameTree(p.left, q.left) && same && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree test = new SameTree();

        // Example 1
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t2.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t2.right = new TreeNode(3);
        System.out.println(test.isSameTree(t1, t2) == true);

        // Example 2
        t1 = new TreeNode(1);
        t2 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t2.right = new TreeNode(2);
        System.out.println(test.isSameTree(t1, t2) == false);

        // Example 3
        t1 = new TreeNode(1);
        t2 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t2.left = new TreeNode(1);
        t1.right = new TreeNode(1);
        t2.right = new TreeNode(2);
        System.out.println(test.isSameTree(t1, t2) == false);
    }
}
