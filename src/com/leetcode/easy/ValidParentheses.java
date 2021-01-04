package com.leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                if ((c == ')' && stack.peek() == '(') ||
                        (c == ']' && stack.peek() == '[') ||
                        (c == '}' && stack.peek() == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();

        // Example 1
        String s = "()";
        System.out.println(test.isValid(s));

        // Example 2
        s = "()[]{}";
        System.out.println(test.isValid(s));

        // Example 3
        s = "(]";
        System.out.println(test.isValid(s));

        // Example 4
        s = "([)]";
        System.out.println(test.isValid(s));

        // Example 5
        s = "{[]}";
        System.out.println(test.isValid(s));
    }
}
