package com.leetcode.easy;

// tag: backtrack
public class IslandPerimeter {
    // Better solution
    public int islandPerimeter2(int[][] grid) {
        int p = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){

                    //assume it is an unconnected cell with perimeter = 4
                    p += 4;

                    //check connection to the left
                    if(j > 0 && grid[i][j - 1] == 1) p += -1;

                    //check connection up
                    if(i > 0 && grid[i-1][j] == 1) p += -1;

                    //check connection to the right
                    if(j < n - 1 && grid[i][j + 1] == 1) p += -1;

                    //check bottom connection
                    if(i < m - 1 && grid[i+1][j] == 1) p += -1;
                }
            }
        }

        return p;
    }

    int answer;

    public int islandPerimeter(int[][] grid) {
        answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    break;
                }
            }
        }

        return answer;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            answer++;
            return;
        } else if (grid[i][j] == 2) {
            return;
        }

        grid[i][j] = 2;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        IslandPerimeter test = new IslandPerimeter();

        // Example 1
        int[][] grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int result = test.islandPerimeter(grid);
        System.out.println(result == 16);

        // Example 2
        grid = new int[][]{{1}};
        result = test.islandPerimeter(grid);
        System.out.println(result == 4);

        // Example 3
        grid = new int[][]{{1, 0}};
        result = test.islandPerimeter(grid);
        System.out.println(result == 4);
    }
}
