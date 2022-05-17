package com.leetcode.meta;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// Tag: stack?
public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        char[] strArray = s.toCharArray();
        char[] strArray2 = new char[strArray.length];
        Stack<Integer> leftParenthesStack = new Stack<>();

        for (int i = 0; i < strArray.length; i++) {
            char c = strArray[i];
            if (c == '(') {
                leftParenthesStack.push(i);
                strArray2[i] = c;
            } else if (c == ')') {
                if (leftParenthesStack.size() != 0) {
                    leftParenthesStack.pop();
                    strArray2[i] = c;
                }
            } else {
                strArray2[i] = c;
            }
        }

        while (!leftParenthesStack.isEmpty()) {
            int ind = leftParenthesStack.pop();
            strArray2[ind] = '\0';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray2.length; i++) {
            if (strArray2[i] != '\0') {
                sb.append(strArray2[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses test = new MinimumRemoveToMakeValidParentheses();

        String s = "lee(t(c)o)de)";
        String result = test.minRemoveToMakeValid(s);
        System.out.println(result);

        s = "a)b(c)d";
        result = test.minRemoveToMakeValid(s);
        System.out.println(result);

        s = "))((";
        result = test.minRemoveToMakeValid(s);
        System.out.println(result);

    }
}
