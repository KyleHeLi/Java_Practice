package com.leetcode.amazon;

import sun.awt.image.ImageWatched;

import java.util.*;

// Top Amazon Questions
// tag: BFS, array
public class ShortestPathInBinaryMatrix {

    int[][] dir = new int[][]{
            // 8 directions
            // NW
            {-1, -1},

            // N
            {-1, 0},

            // NE
            {-1, 1},

            // E
            {0, 1},

            // SE
            {1, 1},

            // S
            {1, 0},

            // SW
            {1, -1},

            // W
            {0, -1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {

        // Firstly, we need to check that the start and target cells are open.
        if (grid == null || grid.length < 1 || grid[0][0] != 0) {
            return -1;
        }

        // Set up the BFS.
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});

        // Carry out the BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                queue.add(new int[]{neighbourRow, neighbourCol});
                grid[neighbourRow][neighbourCol] = distance + 1;
            }
        }

        // The target was unreachable.
        return -1;
    }

    private List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int i = 0; i < dir.length; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }

    // TODO
//    public int shortestPathBinaryMatrix(int[][] grid) {
//        if (grid == null || grid.length < 1 || grid[0][0] == 1) {
//            return -1;
//        }
//
//        int n = grid.length;
//
//        Queue<List<int[]>> queue = new LinkedList<>();
//        Queue<boolean[][]> visitedQueue = new LinkedList<>();
//        queue.add(new ArrayList<>());
//        visitedQueue.add(new boolean[n][n]);
//
//        int result = -1;
//        int i = 0, j = 0;
//        int tmp = 0;
//        while (!queue.isEmpty()) {
//            if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 1) continue;
//
//            List<int[]> items = queue.poll();
//            boolean[][] visited = visitedQueue.poll();
//
//            for (int k = 0; k < dir.length; k++) {
//                List<int[]> next = new LinkedList<>(items);
//                next.add()
//                queue.add(next);
//            }
//
//
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix test = new ShortestPathInBinaryMatrix();

        // Example 1
        int[][] grid = new int[][]{{0, 1}, {1, 0}};
        int expected = 2;
        int actual = test.shortestPathBinaryMatrix(grid);
        System.out.println(expected == actual);

        // Example 2
        grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        expected = 4;
        actual = test.shortestPathBinaryMatrix(grid);
        System.out.println(expected == actual);

        // Example 3
        grid = new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        expected = -1;
        actual = test.shortestPathBinaryMatrix(grid);
        System.out.println(expected == actual);
    }
}
