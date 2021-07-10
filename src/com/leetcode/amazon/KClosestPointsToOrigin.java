package com.leetcode.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Top Amazon Questions
// tag: Array, sort, MinHeap(Priority Queue)
public class KClosestPointsToOrigin {

    // same performance as using minHeap
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length < k) {
            return new int[0][0];
        } else if (points.length == k) {
            return points;
        }

        Arrays.sort(points, (int[] a, int[] b) -> {
            // sort by distance from origin
            return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
        });

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }

        return result;
    }

//    public int[][] kClosest(int[][] points, int k) {
//        if (points == null || points.length < k) {
//            return new int[0][0];
//        } else if (points.length == k) {
//            return points;
//        }
//
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return Math.abs(o1[0] * o1[0] + o1[1] * o1[1]) - Math.abs(o2[0] * o2[0] + o2[1] * o2[1]);
//            }
//        });
//
//        pq.addAll(Arrays.asList(points));
//
//        int[][] result = new int[k][2];
//
//        for (int i = 0; i < k; i++) {
//            result[i] = pq.poll();
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        KClosestPointsToOrigin test = new KClosestPointsToOrigin();

        // Example 1
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int k = 1;
        int[][] expected = new int[][]{{-2, 2}};
        int[][] actual = test.kClosest(points, k);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(Arrays.equals(expected[i], actual[i]));
        }

        // Example 2
        points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        k = 2;
        expected = new int[][]{{3, 3}, {-2, 4}};
        actual = test.kClosest(points, k);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(Arrays.equals(expected[i], actual[i]));
        }

        // Example 3
        points = new int[][]{{-5, 4}, {-6, -5}, {4, 6}};
        k = 2;
        expected = new int[][]{{-5, 4}, {4, 6}};
        actual = test.kClosest(points, k);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(Arrays.equals(expected[i], actual[i]));
        }
    }
}
