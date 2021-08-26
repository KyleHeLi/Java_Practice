package com.leetcode.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Amazon Top Questions
// tag: heap(priority queue), greedy
public class MaximumNumberOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        if (events == null || events.length == 0) return 0;
        final int N = events.length;
        // Sort events by start day.
        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        // Store end days of in progress events in min heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Join the earliest ending in progress events from the earliest start event to the latest start event.
        int i = 0, day = 0, res = 0;
        while (i < N || !pq.isEmpty()) {
            // Get current date.
            if (pq.isEmpty()) {
                day = events[i][0];
            }
            // Add just started events at current day in the min heap.
            while (i < N && day == events[i][0]) {
                pq.add(events[i][1]);
                i++;
            }
            // Join the earliest ending event.
            pq.poll();
            res++;
            day++;
            // Remove already ended events.
            while (!pq.isEmpty() && day > pq.peek()) {
                pq.poll();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumNumberOfEventsThatCanBeAttended test = new MaximumNumberOfEventsThatCanBeAttended();

        // Example 1
        int[][] events = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        int expected = 3;
        int actual = test.maxEvents(events);
        System.out.println(expected == actual);

        // Example 2
        events = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}};
        expected = 4;
        actual = test.maxEvents(events);
        System.out.println(expected == actual);

        // Example 3
        events = new int[][]{{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
        expected = 4;
        actual = test.maxEvents(events);
        System.out.println(expected == actual);

        // Example 4
        events = new int[][]{{1, 100000}};
        expected = 1;
        actual = test.maxEvents(events);
        System.out.println(expected == actual);

        // Example 5
        events = new int[][]{{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}};
        expected = 7;
        actual = test.maxEvents(events);
        System.out.println(expected == actual);

        // Example 6
        events = new int[][]{{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}};
        expected = 5;
        actual = test.maxEvents(events);
        System.out.println(expected == actual);
    }
}
