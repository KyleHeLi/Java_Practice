package com.leetcode.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        List<Integer> sequence = new ArrayList<Integer>();
        List<Node> queue = new LinkedList<Node>();

        queue.add(this);
        queue.add(null);

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

    private void BFS(List<Integer> sequence, List<Node> queue) {
        while (!queue.isEmpty()) {
            Node current = queue.remove(0);

            if (current == null) {
                sequence.add(Integer.MIN_VALUE);
            } else {
                sequence.add(current.val);

                if (current.children != null) {
                    for (Node child : current.children) {
                        queue.add(child);
                    }
                    queue.add(null);
                }
            }
        }
    }
}
