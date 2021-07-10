package com.leetcode.amazon;

import java.util.*;

// Amazon Top Questions
// Tag: DFS, Graph
public class NumberOfConnectedComponentsInAnUndirectedGraph {

//  Algorithm
//      1. Create an adjacency list such that adj[v] contains all the adjacent vertices of vertex v.
//      2. Initialize a hashmap or array, visited, to track the visited vertices.
//      3. Define a counter variable and initialize it to zero.
//      4. Iterate over each vertex in edges, and if the vertex is not already in visited, start a DFS from it. Add every vertex visited during the DFS to visited.
//      5. Every time a new DFS starts, increment the counter variable by one.
//      6. At the end, the counter variable will contain the number of connected components in the undirected graph.
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        int[] visited = new int[n];

        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components;
    }

    private void dfs(List<Integer>[] adjList, int[] visited, int startNode) {
        visited[startNode] = 1;

        for (int i = 0; i < adjList[startNode].size(); i++) {
            if (visited[adjList[startNode].get(i)] == 0) {
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph test = new NumberOfConnectedComponentsInAnUndirectedGraph();

        // Example 1
        int n = 5;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        int expected = 2;
        int actual = test.countComponents(n, edges);
        System.out.println(expected == actual);

        // Example 2
        n = 5;
        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        expected = 1;
        actual = test.countComponents(n, edges);
        System.out.println(expected == actual);
    }
}
