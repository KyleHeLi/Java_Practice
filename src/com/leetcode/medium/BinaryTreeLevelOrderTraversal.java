package com.leetcode.medium;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Tag: Binary Search Tree
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> sequence = new ArrayList<List<Integer>>();
        List<TreeNode> levelQueue = new LinkedList<TreeNode>();
        if (root != null) {
            levelQueue.add(root);

            levelOrder(sequence, levelQueue, 0);
        }

        return sequence;
    }

    private void levelOrder(List<List<Integer>> sequence, List<TreeNode> queue, int level) {
        if (queue.size() == 0) {
            return;
        }

        while (sequence.size() <= level) {
            sequence.add(new ArrayList<Integer>());
        }

        int size = queue.size();
        while (size > 0) {
            TreeNode current = queue.remove(0);
            sequence.get(level).add(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            size--;
        }

        levelOrder(sequence, queue, level + 1);
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal test = new BinaryTreeLevelOrderTraversal();

        // Example
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> a = test.levelOrder(root);
    }
}
