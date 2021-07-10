package com.leetcode.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

// Top Amazon Questions
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        if ((horizontalCuts == null || horizontalCuts.length == 0) && (verticalCuts == null || verticalCuts.length == 0)) {
            return h * w;
        }

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length;
        int m = verticalCuts.length;

        // Consider the edges first
        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        for (int i = 1; i < n; i++) {
            // horizontalCuts[i] - horizontalCuts[i - 1] represents the distance between
            // two adjacent edges, and thus a possible height
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        // Consider the edges first
        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for (int i = 1; i < m; i++) {
            // verticalCuts[i] - verticalCuts[i - 1] represents the distance between
            // two adjacent edges, and thus a possible width
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }

        // Be careful of overflow, and don't forget the modulo!
        return (int) ((maxWidth * maxHeight) % (1000000007));
    }

    public static void main(String[] args) {
        MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts test = new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();

        // Example 1
        int h = 5, w = 4;
        int[] horizontalCuts = new int[]{1, 2, 4}, verticalCuts = new int[]{1, 3};
        int expected = 4;
        int actual = test.maxArea(h, w, horizontalCuts, verticalCuts);
        System.out.println(expected == actual);

        // Example 2
        h = 5;
        w = 4;
        horizontalCuts = new int[]{3, 1};
        verticalCuts = new int[]{1};
        expected = 6;
        actual = test.maxArea(h, w, horizontalCuts, verticalCuts);
        System.out.println(expected == actual);

        // Example 3
        h = 5;
        w = 4;
        horizontalCuts = new int[]{3};
        verticalCuts = new int[]{3};
        expected = 9;
        actual = test.maxArea(h, w, horizontalCuts, verticalCuts);
        System.out.println(expected == actual);

        // Example 4
        h = 1000000000;
        w = 1000000000;
        horizontalCuts = new int[]{2};
        verticalCuts = new int[]{2};
        expected = 81;
        actual = test.maxArea(h, w, horizontalCuts, verticalCuts);
        System.out.println(expected == actual);
    }
}
