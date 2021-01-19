package com.leetcode.medium;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// Tag: Binary Search Tree
// Tag: DP problem
public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }

        List<TreeNode>[][] dp = new List[n+1][n+1];

        return generateTrees(1, n, dp);
    }

    private List<TreeNode> generateTrees(int start, int end, List<TreeNode>[][] dp) {
        if (start > end) {
            List<TreeNode> t = new ArrayList<TreeNode>();
            t.add(null);
            return t;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        List<TreeNode> result = new ArrayList<TreeNode>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1, dp);
            List<TreeNode> right = generateTrees(i + 1, end, dp);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode n = new TreeNode(i);
                    n.left = l;
                    n.right = r;
                    result.add(n);
                }
            }
        }
        dp[start][end] = result;
        return result;
    }

    private static boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if ((t1 == null && t2 != null) || (t1 != null && t2 == null)) {
            return false;
        }

        return t1.val == t2.val && equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreeII test = new UniqueBinarySearchTreeII();

//        // Test 1
//        TreeNode t1 = new TreeNode();
//        TreeNode t2 = new TreeNode();
//        System.out.println(test.equals(t1, t2) == true);
//
//        t1.left = new TreeNode(1);
//        t2.left = new TreeNode(1);
//        System.out.println(test.equals(t1, t2) == true);
//
//        t1.right = new TreeNode(2);
//        t2.right = new TreeNode(2);
//        System.out.println(test.equals(t1, t2) == true);
//
//        t1.right.left = new TreeNode(3);
//        t2.right.left = new TreeNode(3);
//        System.out.println(test.equals(t1, t2) == true);
//
//        t1.right.right = new TreeNode(4);
//        System.out.println(test.equals(t1, t2) == false);

        // Example
        List<TreeNode> result = test.generateTrees(3);
        System.out.println("[");
        for (TreeNode node : result) {
            System.out.println(node);
        }
        System.out.println("]");
    }
}
