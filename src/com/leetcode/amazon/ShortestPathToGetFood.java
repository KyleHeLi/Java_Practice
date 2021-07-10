package com.leetcode.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Top Amazon Question
// tag: BFS
public class ShortestPathToGetFood {

    // Better solution, O(mn), BFS
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        stop:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    break stop;
                }
            }
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] dir : dirs) {
                    int nextx = cur[0] + dir[0];
                    int nexty = cur[1] + dir[1];

                    if (nextx < 0 || nextx >= m || nexty < 0 || nexty >= n || visited[nextx][nexty] || grid[nextx][nexty] == 'X') {
                        continue;
                    }

                    if (grid[nextx][nexty] == '#') {
                        return steps;
                    }

                    queue.add(new int[]{nextx, nexty});
                    visited[nextx][nexty] = true;
                }
            }
        }

        return -1;
    }

//    boolean visited[][];
//    int min;
//
//    public int getFood(char[][] grid) {
//
//        min = -1;
//        visited = new boolean[grid.length][grid[0].length];
//
//        int[] start = new int[2];
//
//        end:
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == '*') {
//                    start[0] = i;
//                    start[1] = j;
//                    break end;
//                }
//            }
//        }
//
//        dfs(grid, start[0], start[1], visited, 0);
//
//        return min;
//    }
//
//    private int dfs(char[][] grid, int i, int j, boolean[][] visited, int count) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
//                || visited[i][j]
//                || grid[i][j] == 'X') {
//            return -1;
//        }
//
//        visited[i][j] = true;
//
//        if (grid[i][j] == '#') {
//            visited[i][j] = false;
//            if (this.min == -1 || this.min > count) {
//                this.min = count;
//            }
//            return count;
//        }
//
//        int min = Integer.MAX_VALUE;
//        // up
//        int tmp = dfs(grid, i - 1, j, visited, count + 1);
//        min = tmp != -1 ? Math.min(min, tmp) : Integer.MAX_VALUE;
//
//        // left
//        tmp = dfs(grid, i, j - 1, visited, count + 1);
//        min = tmp != -1 ? Math.min(min, tmp) : Integer.MAX_VALUE;
//
//        // down
//        tmp = dfs(grid, i + 1, j, visited, count + 1);
//        min = tmp != -1 ? Math.min(min, tmp) : Integer.MAX_VALUE;
//
//        // right
//        tmp = dfs(grid, i, j + 1, visited, count + 1);
//        min = tmp != -1 ? Math.min(min, tmp) : Integer.MAX_VALUE;
//
//        min = Math.min(min, this.min);
//
//        visited[i][j] = false;
//
//        return min;
//    }

    public static void main(String[] args) {
        ShortestPathToGetFood test = new ShortestPathToGetFood();

        // Example 1
        char[][] grid = new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'O', 'O', 'X'},
                {'X', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}
        };
        int expected = 3;
        int actual = test.getFood(grid);
        System.out.println(expected == actual);

        // Example 2
        grid = new char[][]{
                {'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'X', 'O', 'X'},
                {'X', 'O', 'X', '#', 'X'},
                {'X', 'X', 'X', 'X', 'X'}
        };
        expected = -1;
        actual = test.getFood(grid);
        System.out.println(expected == actual);

        // Example 3
        grid = new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'X', 'O', '#', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}
        };
        expected = 6;
        actual = test.getFood(grid);
        System.out.println(expected == actual);

        // Example 4
        grid = new char[][]{
                {'O', '*'},
                {'#', 'X'}
        };
        expected = 2;
        actual = test.getFood(grid);
        System.out.println(expected == actual);

        // Example 5
        grid = new char[][]{
                {'X', '*'},
                {'#', 'X'}
        };
        expected = -1;
        actual = test.getFood(grid);
        System.out.println(expected == actual);
    }
}
