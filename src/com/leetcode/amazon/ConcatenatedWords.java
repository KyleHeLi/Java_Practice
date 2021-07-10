package com.leetcode.amazon;

import com.leetcode.common.Utils;

import java.util.*;

// Top Amazon Questions
// tag: DP, DFS
public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        List<String> result = new ArrayList<>();
        for (String word : words) {
            dfs(word, set, 0, 0, result);
        }
        return result;
    }

    private boolean dfs(String word, HashSet<String> set, int start, int count, List<String> result) {
        if (start == word.length() && count >= 2) {
            result.add(word);
            return true;
        }

        for (int i = start + 1; i <= word.length(); i++) {
            String str = word.substring(start, i);
            if (set.contains(str)) {
                if (dfs(word, set, i, count + 1, result)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ConcatenatedWords test = new ConcatenatedWords();

        // Example 1
        String[] words = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> actual = test.findAllConcatenatedWordsInADict(words);
        Utils.printStringArray(actual);

        // Example 2
        words = new String[]{"cat", "dog", "catdog"};
        actual = test.findAllConcatenatedWordsInADict(words);
        Utils.printStringArray(actual);
    }
}
