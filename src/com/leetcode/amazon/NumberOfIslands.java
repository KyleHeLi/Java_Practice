package com.leetcode.amazon;

import java.util.HashMap;
import java.util.Map;

public class NumberOfIslands {
    Map<Integer, Integer> map;
    int[][] visited;

    public int numIslands(char[][] grid) {
        map = new HashMap<Integer, Integer>();
        visited = new int[grid.length][grid[0].length];

        int index = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                traverse(grid, index, i, j);
                index++;
            }
        }

        return map.keySet().size();
    }

    private void traverse(char[][] grid, int index, int x, int y) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
                || visited[x][y] > 0) {
            return;
        }

        if (grid[x][y] == '1') {
            visited[x][y] = index;
            if (!map.containsKey(index)) {
                map.put(index, 0);
            }
            map.put(index, map.get(index) + 1);
        } else {
            visited[x][y] = 1;
            return;
        }

        // up
        traverse(grid, index, x, y - 1);

        // down
        traverse(grid, index, x, y + 1);

        // left
        traverse(grid, index, x - 1, y);

        // right
        traverse(grid, index, x + 1, y);

    }

    public static void main(String[] args) {
        NumberOfIslands test = new NumberOfIslands();

        // Example 1
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        int result = test.numIslands(grid);
        System.out.println(result == 1);

        // Example 2
        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        result = test.numIslands(grid);
        System.out.println(result == 3);
    }
}
