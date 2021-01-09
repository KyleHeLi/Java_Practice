package com.leetcode.easy;

import com.leetcode.common.TreeNode;
import com.leetcode.common.Node;
import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class N_aryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();

        postorder(result, root);

        return result;
    }

    private void postorder(List<Integer> sequence, Node node) {
        if (node == null) {
            return;
        }

        if (node.children != null) {
            for (Node child : node.children) {
                postorder(sequence, child);
            }
        }

        sequence.add(node.val);
    }

    public static void main(String[] args) {
        N_aryTreePostorderTraversal test = new N_aryTreePostorderTraversal();

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
        Utils.printIntergerArray(test.postorder(root));

//        // Example 2
//        root = new Node(1);
//        level1 = new ArrayList<Node>();
//        level1.add(new Node(2));
//        level1.add(new Node(3));
//        level1.add(new Node(4));
//        level1.add(new Node(5));
//        root.children = level1;
//        level2 = new ArrayList<Node>();
//        level2.add(new Node(6));
//        level2.add(new Node(7));
//        level1.get(1).children = level2;
//        level2 = new ArrayList<Node>();
//        level2.add(new Node(8));
//        level1.get(2).children = level2;
//        level2 = new ArrayList<Node>();
//        level2.add(new Node(9));
//        level2.add(new Node(10));
//        level1.get(3).children = level2;
//        List<Node> level3 = new ArrayList<Node>();
//        level3.add(new Node(11));
//        level2.get(1).children = level3;
//        level3 = new ArrayList<Node>();
//        level3.add(new Node(12));
//        level2.get(2).children = level3;
//        level3 = new ArrayList<Node>();
//        level3.add(new Node(13));
//        level2.get(3).children = level3;
//        List<Node> level4 = new ArrayList<Node>();
//        level4.add(new Node(14));
//        level3.get(0).children = level4;
//        System.out.println(root);
    }
}
