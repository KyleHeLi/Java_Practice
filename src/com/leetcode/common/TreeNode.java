package com.leetcode.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode implements Cloneable {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(List<TreeNode> nodes) {

    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        List<Integer> sequence = new ArrayList<Integer>();
        List<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(this);

        BFS(sequence, queue);


        for (int i = 0, length = sequence.size(); i < length; i++) {
            if (sequence.get(i).equals(Integer.MIN_VALUE)) {
                sb.append("null");
            } else {
                sb.append(sequence.get(i));
            }

            if (i + 1 < length) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    private void BFS(List<Integer> sequence, List<TreeNode> queue) {
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove(0);

            if (current == null) {
                sequence.add(Integer.MIN_VALUE);
            } else {
                sequence.add(current.val);

                if (current.left == null && current.right == null) {
                    continue;
                }

                queue.add(current.left);
                queue.add(current.right);
            }
        }
    }
}
