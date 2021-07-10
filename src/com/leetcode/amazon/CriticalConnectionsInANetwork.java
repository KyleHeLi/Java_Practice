package com.leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// Top Amazon Questions
// tag: DFS, graph
public class CriticalConnectionsInANetwork {
    // Tarjan's Algorithm Complexity: O(V+E)
    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] parent = new int[n];
        int[] disc = new int[n];
        int[] low = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            parent[i] = -1;
            disc[i] = -1;
            low[i] = -1;
        }

        for (List<Integer> edge : connections) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        List<List<Integer>> criticals = new ArrayList<>();
        dfs(adj, criticals, disc, low, parent, 0);

        return criticals;
    }

    private void dfs(List<List<Integer>> adj, List<List<Integer>> criticals, int[] disc, int[] low, int[] parent, int u) {
        disc[u] = time;
        low[u] = time;
        time++;

        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                parent[v] = u;
                dfs(adj, criticals, disc, low, parent, v);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    criticals.add(Arrays.asList(u, v));
                }
            } else if (parent[u] != v) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        CriticalConnectionsInANetwork test = new CriticalConnectionsInANetwork();

        // Example 1
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(new Integer[]{0, 1}));
        connections.add(Arrays.asList(new Integer[]{1, 2}));
        connections.add(Arrays.asList(new Integer[]{2, 0}));
        connections.add(Arrays.asList(new Integer[]{1, 3}));
    }
}


// Solutions:

//Kosaraju's AlgorithmComplexity: O(V+E)
//        Two DFS Traversal
//
//        The idea is to apply Kosaraju's algorithm to get the strongly connected components
//        In first DFS we get the order of the traversal of nodes
//        A slight improvement which can be done here is that instead of taking transpose of the graph(Since this is undirected graph) just remove the edge from the parent
//        Now while doing the 2nd dfs whenever we pop from stack and visit it means we have encountered a new strongly connected component. So we add this edge as a critical connection. Note here that for the first time parent[v] = -1 so we dont have to add.
//        Benefits of using this algorithm is its fairly simple to understand than Tarjan's algorithm
//class Solution {
//    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
//        List<Set<Integer>> adj = new ArrayList<>();
//        int[] parent = new int[n];
//        for(int i=0;i<n;i++){
//            adj.add(new HashSet<>()); // We use hashset so that removal of edge is quick
//            parent[i] = -1;
//        }
//        for(List<Integer> edge: connections) {
//            adj.get(edge.get(0)).add(edge.get(1));
//            adj.get(edge.get(1)).add(edge.get(0));
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        boolean[] visited = new boolean[n];
//        for(int i=0;i<n;i++) {
//            if(!visited[i]){
//                getOrder(adj, stack, parent, visited, i); // Fill stack for ordering
//            }
//        }
//
//        for(int i=0;i<n;i++){
//            if(parent[i]!=-1){
//                adj.get(parent[i]).remove(i); // This is similar to the case where we have to build the transpose graph as per Kosaraju's Algo
//            }
//        }
//        Arrays.fill(visited, false);
//
//        List<List<Integer>> criticals = new ArrayList<>();
//        while(!stack.isEmpty()) {
//            int v = stack.pop();
//            if(!visited[v]){
//                if(parent[v]!=-1){
//                    criticals.add(Arrays.asList(parent[v], v)); // Whenever we pop from stack and the component is unvisited it means a new SCC
//                }
//                dfs(adj, visited, v);
//            }
//        }
//
//        return criticals;
//    }
//
//    private void getOrder(List<Set<Integer>> adj, Stack<Integer> stack, int[] parent, boolean[] visited, int s) {
//        visited[s] = true;
//
//        for(int n: adj.get(s)) {
//            if(!visited[n]){
//                parent[n] = s;
//                getOrder(adj, stack, parent, visited, n);
//            }
//        }
//
//        stack.push(s);
//    }
//
//    private void dfs(List<Set<Integer>> adj, boolean[] visited, int s) {
//        visited[s] = true;
//
//        for(int n: adj.get(s)) {
//            if(!visited[n]){
//                dfs(adj, visited, n);
//            }
//        }
//
//    }
//}
//Tarjan's Algorithm Complexity: O(V+E)
//        One DFS Traversal
//
//        This algorithm uses the concept of the discovery & low time to find the back-edge
//        If for any edge u->v , low[v] > disc[u] it means that the lowest node which can be reached from v comes after u therefore there is no way to reach the strongly connected component which contains the node u. Therefore u->v is a critical connection
//class Solution {
//    private int time = 0;
//
//    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
//        List<List<Integer>> adj = new ArrayList<>();
//        int[] parent = new int[n];
//        int[] disc = new int[n];
//        int[] low = new int[n];
//
//        for(int i=0;i<n;i++){
//            adj.add(new ArrayList<>());
//            parent[i] = -1;
//            disc[i] = -1;
//            low[i] = -1;
//        }
//
//        for(List<Integer> edge: connections) {
//            adj.get(edge.get(0)).add(edge.get(1));
//            adj.get(edge.get(1)).add(edge.get(0));
//        }
//
//        List<List<Integer>> criticals = new ArrayList<>();
//        dfs(adj, criticals, disc, low, parent, 0);
//
//        return criticals;
//    }
//
//    private void dfs(List<List<Integer>> adj, List<List<Integer>> criticals, int[] disc, int[] low, int[] parent, int u) {
//        disc[u] = time;
//        low[u] = time;
//        time++;
//
//        for(int v: adj.get(u)){
//            if(disc[v]==-1) {
//                parent[v] = u;
//                dfs(adj,criticals, disc,low,parent,v);
//                low[u] = Math.min(low[u], low[v]);
//
//                if(low[v]>disc[u]){
//                    criticals.add(Arrays.asList(u,v));
//                }
//            } else if(parent[u]!=v) {
//                low[u] = Math.min(low[u], disc[v]);
//            }
//        }
//    }
//}
