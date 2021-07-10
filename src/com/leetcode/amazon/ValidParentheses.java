package com.leetcode.amazon;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        boolean result = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                char pop = stack.pop();
                if (pop == '(' && ch == ')' ||
                        pop == '[' && ch == ']' ||
                        pop == '{' && ch == '}') {
                    continue;
                } else {
                    result = false;
                    break;
                }
            } else {
                result = false;
                break;
            }
        }

        if (!stack.isEmpty()) {
            result = false;
        }

        return result;
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
