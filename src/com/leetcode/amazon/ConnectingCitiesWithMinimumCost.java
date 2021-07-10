package com.leetcode.amazon;

import java.util.*;

// Top Amazon Questions
// tag: Minimum Spanning Tree, Graph, Union Find
public class ConnectingCitiesWithMinimumCost {
    // Better solution
    public int minimumCost(int n, int[][] connections) {
        // for MST, must have vertixes - 1 edges at least
        if (connections.length < n - 1) {
            return -1;
        }

        int[] groups = new int[n + 1];
        // init every node to its own group
        for (int i = 1; i <= n; i++) {
            groups[i] = i;
        }

        int length = 0;
        Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2])); // sort by edge distance asc
        for (int[] edge : connections) {
            int p1 = find(groups, edge[0]);
            int p2 = find(groups, edge[1]);
            if (p1 != p2) { // union if they are not already in same set, add the length to our output
                length += edge[2];
                union(groups, p1, p2);
            }
        }

        // do final path compression
        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != i) {
                compressPath(groups, i);
            }
        }

        // check that only 1 parent node exists, can return -1 if there are ever 2 different root nodes detected
        int parent = groups[1];
        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != parent) {
                return -1;
            }
        }
        return length;
    }

    private void compressPath(int[] groups, int p) {
        int root = p; // need to save original P, because we need to set everyhthing on p...root after finding root
        while (root != groups[root]) {
            root = groups[root];
        }
        // root is correct parent here, set everything along the way of [p .. root]
        while (root != p) {
            int tmp = groups[p];
            groups[p] = root;
            p = tmp;
        }
    }

    private int find(int[] groups, int p) {
        int root = p;
        // find all the way up to our root
        while (root != groups[root]) {
            root = groups[root];
        }
        return root;
    }

    // should only be called on the roots
    private void union(int[] groups, int a, int b) {
        if (groups[a] < groups[b]) {
            groups[b] = groups[a];
        } else {
            groups[a] = groups[b];
        }
    }


    // TODO: not finished Dijkstra
//    public int minimumCost(int n, int[][] connections) {
//        if (n < 1 || connections == null || connections.length == 0 || connections[0].length < 3) {
//            return -1;
//        }
//
//        int result = Integer.MAX_VALUE;
//
//        Set<Integer> cities = new HashSet<>();
//        for (int i = 0; i < connections.length; i++) {
//            if (!cities.contains(connections[i][0])) {
//                cities.add(connections[i][0]);
//            }
//
//            if (!cities.contains(connections[i][1])) {
//                cities.add(connections[i][1]);
//            }
//        }
//
//        Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
//        for (int i = 0; i < connections.length; i++) {
//            if (!map.containsKey(connections[i][0])) {
//                map.put(connections[i][0], new HashMap<Integer, Integer>());
//            }
//
//            map.get(connections[i][0]).put(connections[i][1], connections[i][2]);
//        }
//
//        for (Integer key : map.keySet()) {
//            int count = 0;
//            int sum = 0;
//
//            for (Integer city : cities) {
//                if (city == key) continue;
//
//                if (!map.get(key).containsKey(city)) {
//                    map.get(key).put(city, Integer.MAX_VALUE);
//                }
//
//
//            }
//
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCost test = new ConnectingCitiesWithMinimumCost();

        // Example 1
        int n = 3;
        int[][] connections = new int[][]{
                {1, 2, 5},
                {1, 3, 6},
                {2, 3, 1}
        };
        int expected = 6;
        int actual = test.minimumCost(n, connections);
        System.out.println(expected == actual);

        // Example 2
        n = 4;
        connections = new int[][]{
                {1, 2, 3},
                {3, 4, 4},
        };
        expected = -1;
        actual = test.minimumCost(n, connections);
        System.out.println(expected == actual);
    }
}
