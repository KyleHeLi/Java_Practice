package com.leetcode.amazon;

import java.util.*;

// Top Amazon Questions
// tag: DFS / BFS Kann's algorithm, Graph, Topological Sort
public class CourseScheduleII {
//    The idea here is:
//      1. Prepare a graph with directed edges
//      2. Take a Stack to push values based on topological sort.
//      3. Reck stack to keep track of parent node while doing DSF. This tells us if cycle exists or not.

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //prepare graph

        List<List<Integer>> graph = new ArrayList<>();


        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] pair : prerequisites) {
            int a = pair[0];
            int b = pair[1];
            graph.get(b).add(a);
        }

        int res[] = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] reckStack = new boolean[numCourses]; //topo sort + cyclic

        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(i, visited, st, graph, reckStack)) return new int[0];

        }

        int i = 0;
        while (!st.isEmpty()) {
            res[i] = st.pop();
            i++;
        }

        return res;
    }

    public boolean isCyclic(int i, boolean[] visited, Stack<Integer> st, List<List<Integer>> graph,
                            boolean[] reckStack) {
        if (reckStack[i]) return true;
        if (visited[i]) return false;

        visited[i] = true;
        reckStack[i] = true;
        for (Integer c : graph.get(i)) {
            if (isCyclic(c, visited, st, graph, reckStack)) return true;
        }

        st.push(i);
        reckStack[i] = false;
        return false;
    }


    public static void main(String[] args) {
        CourseScheduleII test = new CourseScheduleII();

        // Example 1
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        int[] expected = new int[]{0, 1};
        int[] actual = test.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.equals(expected, actual));

        // Example 2
        numCourses = 4;
        prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        expected = new int[]{0, 2, 1, 3};
        actual = test.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.equals(expected, actual));

        // Example 3
        numCourses = 1;
        prerequisites = new int[0][0];
        expected = new int[]{0};
        actual = test.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.equals(expected, actual));

        // Example 4
        numCourses = 2;
        prerequisites = new int[0][0];
        expected = new int[]{1, 0};
        actual = test.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.equals(expected, actual));
    }
}

// Solutions

// Algorithm
//  1. Initialize a stack S that will contain the topologically sorted order of the courses in our graph.
//  2. Construct the adjacency list using the edge pairs given in the input. An important thing to note about the input for the problem is that a pair such as [a, b] represents that the course b needs to be taken in order to do the course a. This implies an edge of the form b ➔ a. Please take note of this when implementing the algorithm.
//  3. For each of the nodes in our graph, we will run a depth first search in case that node was not already visited in some other node's DFS traversal.
//  4. Suppose we are executing the depth first search for a node N. We will recursively traverse all of the neighbors of node N which have not been processed before.
//  5. Once the processing of all the neighbors is done, we will add the node N to the stack. We are making use of a stack to simulate the ordering we need. When we add the node N to the stack, all the nodes that require the node N as a prerequisites (among others) will already be in the stack.
//  6. Once all the nodes have been processed, we will simply return the nodes as they are present in the stack from top to bottom.

//class Solution {
//    static int WHITE = 1;
//    static int GRAY = 2;
//    static int BLACK = 3;
//
//    boolean isPossible;
//    Map<Integer, Integer> color;
//    Map<Integer, List<Integer>> adjList;
//    List<Integer> topologicalOrder;
//
//    private void init(int numCourses) {
//        this.isPossible = true;
//        this.color = new HashMap<Integer, Integer>();
//        this.adjList = new HashMap<Integer, List<Integer>>();
//        this.topologicalOrder = new ArrayList<Integer>();
//
//        // By default all vertces are WHITE
//        for (int i = 0; i < numCourses; i++) {
//            this.color.put(i, WHITE);
//        }
//    }
//
//    private void dfs(int node) {
//
//        // Don't recurse further if we found a cycle already
//        if (!this.isPossible) {
//            return;
//        }
//
//        // Start the recursion
//        this.color.put(node, GRAY);
//
//        // Traverse on neighboring vertices
//        for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
//            if (this.color.get(neighbor) == WHITE) {
//                this.dfs(neighbor);
//            } else if (this.color.get(neighbor) == GRAY) {
//                // An edge to a GRAY vertex represents a cycle
//                this.isPossible = false;
//            }
//        }
//
//        // Recursion ends. We mark it as black
//        this.color.put(node, BLACK);
//        this.topologicalOrder.add(node);
//    }
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//
//        this.init(numCourses);
//
//        // Create the adjacency list representation of the graph
//        for (int i = 0; i < prerequisites.length; i++) {
//            int dest = prerequisites[i][0];
//            int src = prerequisites[i][1];
//            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
//            lst.add(dest);
//            adjList.put(src, lst);
//        }
//
//        // If the node is unprocessed, then call dfs on it.
//        for (int i = 0; i < numCourses; i++) {
//            if (this.color.get(i) == WHITE) {
//                this.dfs(i);
//            }
//        }
//
//        int[] order;
//        if (this.isPossible) {
//            order = new int[numCourses];
//            for (int i = 0; i < numCourses; i++) {
//                order[i] = this.topologicalOrder.get(numCourses - i - 1);
//            }
//        } else {
//            order = new int[0];
//        }
//
//        return order;
//    }
//}