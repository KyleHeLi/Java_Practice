package com.leetcode.amazon;

import java.util.Stack;

// Top Amazon Questions
// tag: Stack, postfix, post-order traversal
public class DesignAnExpressionTreeWithEvaluateFunction {
    /**
     * This is the interface for the expression tree Node.
     * You should not remove it, and you can define some classes to implement it.
     */

    abstract class Node {
        public abstract int evaluate();

        // define your fields here
        String value;
        Node left;
        Node right;

        Node() {
        }

        Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    class TreeNode extends Node {

        TreeNode(String value) {
            super(value, null, null);
        }

        TreeNode(String value, Node left, Node right) {
            super(value, left, right);
        }

        public int evaluate() {
            return evaluate(this);
        }

        private int evaluate(Node root) {
            if (root == null) return 0;

            if (root.value.matches("[0-9]+")) {
                return Integer.parseInt(root.value);
            }

            switch (root.value) {
                case "+":
                    return evaluate(root.left) + evaluate(root.right);

                case "-":
                    return evaluate(root.left) - evaluate(root.right);

                case "*":
                    return evaluate(root.left) * evaluate(root.right);

                case "/":
                    return evaluate(root.left) / evaluate(root.right);

                default:
                    return 0;
            }
        }
    }

    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            if (postfix == null || postfix.length % 2 == 0) return null;

            Stack<Node> stack = new Stack<>();

            for (int i = 0; i < postfix.length; i++) {
                if (postfix[i].matches("[0-9]+")) {
                    stack.push(new TreeNode(postfix[i]));
                } else {
                    if (stack.size() < 2) return null;
                    Node right = stack.pop();
                    Node left = stack.pop();
                    Node symbol = new TreeNode(postfix[i], left, right);
                    stack.push(symbol);
                }
            }

            if (stack.size() != 1) return null;

            return stack.pop();
        }
    }

    /**
     * Your TreeBuilder object will be instantiated and called as such:
     * TreeBuilder obj = new TreeBuilder();
     * Node expTree = obj.buildTree(postfix);
     * int ans = expTree.evaluate();
     */

    public static void main(String[] args) {
        DesignAnExpressionTreeWithEvaluateFunction test = new DesignAnExpressionTreeWithEvaluateFunction();

        // Example 1
        String[] postfix = new String[]{"3", "4", "+", "2", "*", "7", "/"};
        TreeBuilder obj = test.new TreeBuilder();
        Node expTree = obj.buildTree(postfix);
        int expected = 2;
        int actual = expTree.evaluate();
        System.out.println(expected == actual);

        // Example 2
        postfix = new String[]{"4", "5", "7", "2", "+", "-", "*"};
        obj = test.new TreeBuilder();
        expTree = obj.buildTree(postfix);
        expected = -16;
        actual = expTree.evaluate();
        System.out.println(expected == actual);

        // Example 3
        postfix = new String[]{"4", "2", "+", "3", "5", "1", "-", "*", "+"};
        obj = test.new TreeBuilder();
        expTree = obj.buildTree(postfix);
        expected = 18;
        actual = expTree.evaluate();
        System.out.println(expected == actual);

        // Example 4
        postfix = new String[]{"100", "200", "+", "2", "/", "5", "*", "7", "+"};
        obj = test.new TreeBuilder();
        expTree = obj.buildTree(postfix);
        expected = 757;
        actual = expTree.evaluate();
        System.out.println(expected == actual);
    }
}
