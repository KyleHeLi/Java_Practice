package com.leetcode.amazon;

import java.util.*;

// Top Amazon Questions
// tag: Trie
// reference: https://www.geeksforgeeks.org/trie-insert-and-search/
public class AutocompleteSystem {

    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> count;

        TrieNode() {
            this.children = new HashMap<>();
            this.count = new HashMap<>();
        }
    }

    TrieNode root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        prefix = "";
        root = new TrieNode();
        for (int i = 0; i < sentences.length; i++) {
            addToTrie(sentences[i], times[i]);
        }
    }

    public void addToTrie(String sentence, int times) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            if (!node.children.containsKey(c))
                node.children.put(c, new TrieNode());

            node = node.children.get(c);
            node.count.put(sentence, node.count.getOrDefault(sentence, 0) + times);
        }
    }

    public List<String> input(char c) {
        List<String> retList = new ArrayList<>();

        if (c == '#') {
            addToTrie(prefix, 1);
            prefix = "";
            return retList;
        }

        prefix = prefix + c;

        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else
                return retList;
        }

        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        pq.addAll(node.count.entrySet());
        int count = 3;
        while (!pq.isEmpty() && count > 0) {
            retList.add(pq.poll().getKey());
            count--;
        }
        return retList;
    }

    public static void main(String[] args) {
        AutocompleteSystem obj = new AutocompleteSystem(new String[]{
                "i love you", "island", "iroman", "i love leetcode"
        }, new int[]{
                5, 3, 2, 2
        });
        obj.input('i'); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
        obj.input(' '); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
        obj.input('a'); // return []. There are no sentences that have prefix "i a".
        obj.input('#'); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
    }
}
