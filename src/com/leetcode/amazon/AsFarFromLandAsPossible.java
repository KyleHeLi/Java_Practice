package com.leetcode.amazon;

import java.util.LinkedList;
import java.util.Queue;

// Top Amazon Questions
// tag: DP, BFS
public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        int row = grid.length;
        int col = grid[0].length;
        boolean [][] visited = new boolean [row][col];
        return bfs(grid, visited, row, col);
    }

    public int bfs(int [][] grid, boolean [][] visited, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        int [][] directions = new int [][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int result = -1;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new int [] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int [] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int [] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                if (newX < 0 || newY < 0 || newX >= row || newY >= col || visited[newX][newY]) {
                    continue;
                }
                visited[newX][newY] = true;
                grid[newX][newY] = grid[x][y] + 1;
                result = Math.max(result, grid[newX][newY]);
                queue.offer(new int []{newX, newY});
            }
        }
        return result < 0 ? -1 : result - 1;
    }
}
