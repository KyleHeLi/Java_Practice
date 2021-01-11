package com.leetcode.easy;

import com.leetcode.common.Node;
import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class N_aryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();

        preorder(result, root);

        return result;
    }

    private void preorder(List<Integer> sequence, Node node) {
        if (node == null) {
            return;
        }

        sequence.add(node.val);

        if (node.children != null) {
            for (Node child : node.children) {
                preorder(sequence, child);
            }
        }
    }

    public static void main(String[] args) {
        N_aryTreePreorderTraversal test = new N_aryTreePreorderTraversal();

        // Example 1
        Node root = new Node(1);
        List<Node> level1 = new ArrayList<Node>();
        level1.add(new Node(3));
        level1.add(new Node(2));
        level1.add(new Node(4));
        root.children = level1;
        List<Node> level2 = new ArrayList<Node>();
        level2.add(new Node(5));
        level2.add(new Node(6));
        level1.get(0).children = level2;
        System.out.println(root);
        Utils.printIntergerArray(test.preorder(root));
    }
}
