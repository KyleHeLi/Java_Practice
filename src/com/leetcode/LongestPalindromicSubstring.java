package com.leetcode;

import java.util.Stack;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stringStack = new Stack<Character>();
        char[] stringArray = s.toCharArray();
        for (char c : stringArray) {
            System.out.println(c);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();

        String test1 = "babad";
        System.out.println(test.longestPalindrome(test1));

        String test2 = "cbbd";
        System.out.println(test.longestPalindrome(test2));
    }
}
