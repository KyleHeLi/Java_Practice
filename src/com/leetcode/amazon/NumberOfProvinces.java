package com.leetcode.amazon;

import java.util.HashSet;
import java.util.Set;

// Top Amazon Questions
// tag: DFS / BFS, Uniion find
public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }

    public static void main(String[] args) {

        NumberOfProvinces test = new NumberOfProvinces();

        // Example 1
        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int expected = 2;
        int actual = test.findCircleNum(isConnected);
        System.out.println(expected == actual);

        // Example 2
        isConnected = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        expected = 3;
        actual = test.findCircleNum(isConnected);
        System.out.println(expected == actual);

        // Example 3
        isConnected = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        expected = 1;
        actual = test.findCircleNum(isConnected);
        System.out.println(expected == actual);

        // Example 4
        isConnected = new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        expected = 1;
        actual = test.findCircleNum(isConnected);
        System.out.println(expected == actual);

        // Example 5
        isConnected = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
        expected = 8;
        actual = test.findCircleNum(isConnected);
        System.out.println(expected == actual);

        // Example 6
        isConnected = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        expected = 1;
        actual = test.findCircleNum(isConnected);
        System.out.println(expected == actual);
    }
}
