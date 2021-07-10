package com.leetcode.easy;

public class ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseString test = new ReverseString();
        char[] s = new char[]{'h','e','l','l','o'};
        test.reverseString(s);
        System.out.println(new String(s));

        s = new char[]{'H','a','n','n','a','h'};
        test.reverseString(s);
        System.out.println(new String(s));
    }
}
