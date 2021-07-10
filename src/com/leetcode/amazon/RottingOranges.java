package com.leetcode.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Top Amazon Questions
// tag: BFS
public class RottingOranges {

    /*
     * 0 representing an empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * */

    int dir[][] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0; //count of fresh oranges

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //Put all the rotten orange's indices into our queue
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                //increment the count of fresh oranges
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int time = 0;
        while (q.size() > 0) {
            int count = q.size();

            for (int i = 0; i < count; i++) {
                int rem[] = q.remove();

                for (int d[] : dir) {
                    int ni = rem[0] + d[0];
                    int nj = rem[1] + d[1];
                    //add the adjacent fresh oranges as your rotten orange will rot the adjacent fresh orange only
                    if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == 1) {
                        q.add(new int[]{ni, nj});
                        //mark this as rotten orange, so we dont want to add it again
                        grid[ni][nj] = 2;
                        fresh--;
                    }

                }

            }

            time++;
        }
        //If you are able to rot each and every fresh orange simply return the time, otherwise return -1
        return fresh == 0 ? time - 1 : -1;
    }

    public static void main(String[] args) {
        RottingOranges test = new RottingOranges();

        // Example 1
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int expected = 4;
        int actual = test.orangesRotting(grid);
        System.out.println(expected == actual);

        // Example 2
        grid = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        expected = -1;
        actual = test.orangesRotting(grid);
        System.out.println(expected == actual);

        // Example 3
        grid = new int[][]{{0, 2}};
        expected = 0;
        actual = test.orangesRotting(grid);
        System.out.println(expected == actual);
    }
}
