package com.leetcode.amazon;

import java.util.PriorityQueue;

// Top Amazon Questions
// tag: Heap (Priority Queue)
public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length < 2) {
            return 0;
        }

        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
        for (int i = 0; i < sticks.length; i++) {
            pq.add(sticks[i]);
        }

        while (pq.size() > 1) {
            int tmp = pq.poll() + pq.poll();
            result += tmp;
            pq.add(tmp);
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumCostToConnectSticks test = new MinimumCostToConnectSticks();

        // Example 1
        int[] sticks = new int[]{2, 4, 3};
        int expected = 14;
        int actual = test.connectSticks(sticks);
        System.out.println(expected == actual);

        // Example 2
        sticks = new int[]{1, 8, 3, 5};
        expected = 30;
        actual = test.connectSticks(sticks);
        System.out.println(expected == actual);

        // Example 3
        sticks = new int[]{5};
        expected = 0;
        actual = test.connectSticks(sticks);
        System.out.println(expected == actual);
    }
}
