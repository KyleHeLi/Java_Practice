package com.leetcode.amazon;

import java.util.*;

// Top Amazon Questions
// tag: BFS
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || beginWord.equals(endWord)) {
            return 0;
        }

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String word = queue.poll();

                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    StringBuilder sb = new StringBuilder(word);
                    for (char a = 'a'; a <= 'z'; a++) {
                        if (a != c) {
                            sb.setCharAt(i, a);

                            if (!wordSet.contains(sb.toString()) || visited.contains(sb.toString())) {
                                continue;
                            }

                            if (sb.toString().equals(endWord)) {
                                return count + 1;
                            }

                            queue.offer(sb.toString());
                            visited.add(sb.toString());
                        }
                    }
                }
                size--;
            }

            count++;
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();

        // Example 1
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        int expected = 5;
        int actual = test.ladderLength(beginWord, endWord, wordList);
        System.out.println(actual == expected);

        // Example 2
        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log"});
        expected = 0;
        actual = test.ladderLength(beginWord, endWord, wordList);
        System.out.println(actual == expected);
    }
}
