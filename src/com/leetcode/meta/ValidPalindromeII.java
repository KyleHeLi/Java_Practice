package com.leetcode.meta;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int count = 0;
        int i = 0;
        int j = s.length() - 1;

        if (s.length() <= 2) return true;

        Queue<int[]> record = new LinkedList<>();
        
        while (i <= j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (s.charAt(i) != s.charAt(j)) {
                count++;

                if (count > 1) {
                    if (record.isEmpty()) {
                        break;
                    } else {

                    }
                }

                if (s.charAt(i + 1) == s.charAt(j)) {
                    record.add(new int[]{i+1, j});
                    i++;
                } else if (s.charAt(i) == s.charAt(j - 1) && s.charAt(i + 1) == s.charAt(j - 2)) {
                    record.add(new int[]{i, j-1});
                    j--;
                } else {
                    i++;
                }
            } else {
                i++;
                j--;
            }
        }

        return count < 2;
    }

    public static void main(String[] args) {
        ValidPalindromeII test = new ValidPalindromeII();

        String s = "aba";
        boolean result = test.validPalindrome(s);
        System.out.println(result);

        s = "abca";
        result = test.validPalindrome(s);
        System.out.println(result);

        s = "abc";
        result = test.validPalindrome(s);
        System.out.println(result);

        s = "abbbc";
        result = test.validPalindrome(s);
        System.out.println(result);

        s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        result = test.validPalindrome(s);
        System.out.println(result);

        s = "acxcybycxcxa";
        result = test.validPalindrome(s);
        System.out.println(result);
    }
}
