package com.leetcode.amazon;

import java.util.HashSet;
import java.util.Set;

// Top Amazon Questions
// tag: DFS / BFS
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || start == null || destination == null) {
            return false;
        }

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        return dfs(maze, start[0], start[1], destination, visited);
    }

    private boolean dfs(int[][] maze, int i, int j, int[] destination, boolean[][] visited) {

        if (!canGoThrough(maze, i, j, visited)) {
            return false;
        }

        // When arriving at the destination
        if (destination[0] == i && destination[1] == j) {
            return true;
        }

        visited[i][j] = true;

        int u = i - 1, l = j - 1, d = i + 1, r = j + 1;

        // up
        while (u >= 0 && maze[u][j] == 0) {
            u--;
        }
        boolean up = dfs(maze, u + 1, j, destination, visited);
        if (up) return true;

        // left
        while (l >= 0 && maze[i][l] == 0) {
            l--;
        }
        boolean left = dfs(maze, i, l + 1, destination, visited);
        if (left) return true;

        // down
        while (d < maze.length && maze[d][j] == 0) {
            d++;
        }
        boolean down = dfs(maze, d - 1, j, destination, visited);
        if (down) return true;

        // right
        while (r < maze[0].length && maze[i][r] == 0) {
            r++;
        }
        boolean right = dfs(maze, i, r - 1, destination, visited);
        if (right) return true;

        return false;
    }

    private boolean canGoThrough(int[][] maze, int i, int j, boolean[][] visited) {
        if (maze == null || i < 0 || j < 0 || i >= maze.length || j >= maze[0].length || maze[i][j] == 1 || visited[i][j]) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TheMaze test = new TheMaze();

        // Example 1
        int[][] maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = new int[]{0, 4};
        int[] destination = new int[]{4, 4};
        boolean result = test.hasPath(maze, start, destination);
        System.out.println(result == true);

        // Example 2
        maze = new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        start = new int[]{0, 4};
        destination = new int[]{3, 2};
        result = test.hasPath(maze, start, destination);
        System.out.println(result == false);

        // Example 3
        maze = new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
        start = new int[]{4, 5};
        destination = new int[]{0, 1};
        result = test.hasPath(maze, start, destination);
        System.out.println(result == false);
    }
}
