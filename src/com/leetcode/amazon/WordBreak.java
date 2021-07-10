package com.leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.equals("") || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        boolean[] dp = new boolean[s.length()];
        for (int i = 0, length = s.length(); i < length; i++) {
            for (String word : wordDict) {
                int wordLen = word.length();
                if ((i - wordLen + 1) >= 0 && word.equals(s.substring(i - wordLen + 1, i + 1)) && ((i - wordLen) == -1 || dp[i - wordLen])) {
                    dp[i] = true;
                }
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        WordBreak test = new WordBreak();

        // Example 1
        String s = "leetcode";
        List<String> wordDict = Arrays.asList(new String[]{"leet", "code"});
        boolean expected = true;
        boolean actual = test.wordBreak(s, wordDict);
        System.out.println(actual == expected);

        // Example 2
        s = "applepenapple";
        wordDict = Arrays.asList(new String[]{"apple", "pen"});
        expected = true;
        actual = test.wordBreak(s, wordDict);
        System.out.println(actual == expected);

        // Example 3
        s = "catsandog";
        wordDict = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});
        expected = false;
        actual = test.wordBreak(s, wordDict);
        System.out.println(actual == expected);
    }
}
