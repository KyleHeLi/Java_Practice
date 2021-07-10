package com.leetcode.amazon;

import java.util.*;

// Top Amazon Questions
// tag: Backtracking / DFS
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return result;
        }

        int size = words.length;

        for (int i = 0; i < size; i++) {
            if (search(board, words[i])) {
                result.add(words[i]);
            }
        }

        return result;
    }

    private boolean search(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean found = false;
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    found = dfs(board, word, i, j, 0, new boolean[m][n]);
                }

                if (found) break;
            }

            if (found) break;
        }
        return found;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
        if (k == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || word.charAt(k) != board[i][j] || visited[i][j])
            return false;

        visited[i][j] = true;
        if (dfs(board, word, i + 1, j, k + 1, visited) ||
                dfs(board, word, i - 1, j, k + 1, visited) ||
                dfs(board, word, i, j + 1, k + 1, visited) ||
                dfs(board, word, i, j - 1, k + 1, visited))
            return true;

        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearchII test = new WordSearchII();

        // Example 1
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        List<String> result = test.findWords(board, words);
        System.out.println(result);

        // Example 2
        board = new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        };
        words = new String[]{"abcd"};
        result = test.findWords(board, words);
        System.out.println(result);
    }
}
