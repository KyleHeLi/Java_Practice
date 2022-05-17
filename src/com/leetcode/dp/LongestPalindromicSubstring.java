package com.leetcode.dp;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int maxLength = 0;
        int paliStart = 0;
        for (int end = 0; end < n; end ++) {
            for (int start = end; start >= 0; start--) {
                if (start == end) {
                    isPalindrome[start][end] = true;
                } else if (start == end-1) {
                    isPalindrome[start][end] = s.charAt(start) == s.charAt(end);
                } else {
                    isPalindrome[start][end] = s.charAt(start) == s.charAt(end) && isPalindrome[start+1][end-1];
                }

                int len = end - start + 1;
                if (isPalindrome[start][end] == true && len > maxLength) {
                    maxLength = len;
                    paliStart = start;
                }
            }
        }
        return s.substring(paliStart, paliStart+maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        String s = "babad";
        String res = test.longestPalindrome(s);
        System.out.println(res);

        s = "cbbd";
        res = test.longestPalindrome(s);
        System.out.println(res);

        s = "a";
        res = test.longestPalindrome(s);
        System.out.println(res);

        s = "aacabdkacaa";
        res = test.longestPalindrome(s);
        System.out.println(res);
    }
}
