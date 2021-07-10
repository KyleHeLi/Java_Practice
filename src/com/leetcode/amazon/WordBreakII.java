package com.leetcode.amazon;

import com.leetcode.common.Utils;

import java.util.*;
import java.util.stream.Collectors;

// Top Amazon Questions
// tag: DP, DFS / Backtracking
public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);

        int length = 0;
        for (String word : wordDict) {
            length = Math.max(length, word.length());
        }

        List<List<StringBuilder>> dp = new ArrayList<List<StringBuilder>>();

        for (int i = 0; i <= s.length(); i++) {
            dp.add(new ArrayList<StringBuilder>());
        }

        dp.get(0).add(new StringBuilder());

        for (int i = 1; i <= s.length(); i++) {
            for (int j = Math.max(0, i - length); j < i; j++) {

                String word = s.substring(j, i);
                if (dp.get(j).size() > 0 && dict.contains(word)) {

                    for (StringBuilder prev : dp.get(j)) {

                        StringBuilder sentence = new StringBuilder(prev);
                        if (sentence.length() > 0) {
                            sentence.append(" ");
                        }

                        sentence.append(word);
                        dp.get(i).add(sentence);
                    }
                }
            }
        }

        return dp.get(s.length()).stream().map(sb -> sb.toString()).collect(Collectors.toList());
    }

//    public List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> result = new ArrayList<String>();
//
//        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
//            return result;
//        }
//
//        Set<String> dict = new HashSet<String>(wordDict);
//
//        List<List<StringBuilder>> dp = new ArrayList<List<StringBuilder>>();
//        for (int i = 0; i <= s.length(); i++) {
//            dp.add(new ArrayList<StringBuilder>());
//        }
//        dp.get(0).add(new StringBuilder(""));
//
//        for (String word : wordDict) {
//            if (s.substring(0, word.length()).equals(word)) {
//                StringBuilder sentence = new StringBuilder();
//                sentence.append(word + " ");
//                int j = word.length(), k = j + 1;
//
//                while (j < s.length() && k <= s.length()) {
//                    String tmp = s.substring(j, k);
//
//                    if (dict.contains(tmp)) {
//                        sentence.append(tmp + " ");
//                        j = k;
//                        k = j + 1;
//                    } else {
//                        k++;
//                    }
//                }
//
//                if (j < s.length()) continue;
//
//                result.add(sentence.deleteCharAt(sentence.length() - 1).toString());
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        WordBreakII test = new WordBreakII();

        // Example 1
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});
        String[] expected = new String[]{"cats and dog", "cat sand dog"};
        List<String> actual = test.wordBreak(s, wordDict);
        Utils.printStringArray(actual);

        // Example 2
        s = "pineapplepenapple";
        wordDict = Arrays.asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"});
        expected = new String[]{"pine apple pen apple", "pineapple pen apple", "pine applepen apple"};
        actual = test.wordBreak(s, wordDict);
        Utils.printStringArray(actual);

        // Example 3
        s = "catsandog";
        wordDict = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});
        expected = new String[]{};
        actual = test.wordBreak(s, wordDict);
        Utils.printStringArray(actual);
    }
}

// DP solution
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        Set<String> dict = new HashSet<String>(wordDict);
//
//        int length = 0;
//        for (String word : wordDict) {
//            length = Math.max(length, word.length());
//        }
//
//        List<List<StringBuilder>> dp = new ArrayList<List<StringBuilder>>();
//
//        for (int i = 0; i <= s.length(); i++) {
//            dp.add(new ArrayList<StringBuilder>());
//        }
//
//        dp.get(0).add(new StringBuilder());
//
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = Math.max(0, i - length); j < i; j++) {
//
//                String word = s.substring(j, i);
//                if (dp.get(j).size() > 0 && dict.contains(word)) {
//
//                    for (StringBuilder prev : dp.get(j)) {
//
//                        StringBuilder sentence = new StringBuilder(prev);
//                        if (sentence.length() > 0) {
//                            sentence.append(" ");
//                        }
//
//                        sentence.append(word);
//                        dp.get(i).add(sentence);
//                    }
//                }
//            }
//        }
//
//        return dp.get(s.length()).stream().map(sb -> sb.toString()).collect(Collectors.toList());
//    }

// DFS solution
//    List<String> res = new ArrayList<>();
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        Set<String> set = new HashSet<>();
//
//        for(String s1: wordDict) {
//            set.add(s1);
//        }
//        backTracking(new StringBuilder(), s, 0, set);
//
//        return res;
//    }
//
//
//    private void backTracking(StringBuilder builder, String s, int index, Set<String> set) {
//
//        if(index >= s.length()) {
//            res.add(builder.toString());
//            return;
//        }
//
//        for(int i= index; i<s.length(); i++) {
//            String temp = s.substring(index, i+1);
//            if(set.contains(temp)) {
//
//                if(builder.length() >= 0) {
//                    builder.append(" ");
//
//                }
//                builder.append(temp);
//
//
//
//                backTracking(builder, s, i+1, set);
//                //delete the last added
//                builder.delete(builder.length() - temp.length(), builder.length());
//                if (builder.length() > 0){
//                    builder.delete(builder.length() - 1, builder.length());
//                }
//            }
//        }
//    }