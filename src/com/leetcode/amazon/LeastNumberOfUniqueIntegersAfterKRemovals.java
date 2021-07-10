package com.leetcode.amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Top Amazon Questions
// tag: Heap (Priority Queue), HashMap
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 0);
            }
            map.put(arr[i], map.get(arr[i]) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (Integer key : map.keySet()) {
            queue.add(new int[]{map.get(key), key});
        }

        int rest = map.size();
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                int[] item = queue.poll();
                if (item[0] == 1) {
                    rest--;
                } else {
                    item[0] -= 1;
                    queue.add(item);
                }
            }
        }

        return rest;
    }

    public static void main(String[] args) {
        LeastNumberOfUniqueIntegersAfterKRemovals test = new LeastNumberOfUniqueIntegersAfterKRemovals();

        // Example 1
        int[] arr = new int[]{5, 5, 4};
        int k = 1;
        int expected = 1;
        int actual = test.findLeastNumOfUniqueInts(arr, k);
        System.out.println(expected == actual);

        // Example 2
        arr = new int[]{4, 3, 1, 1, 3, 3, 2};
        k = 3;
        expected = 2;
        actual = test.findLeastNumOfUniqueInts(arr, k);
        System.out.println(expected == actual);

        // Example 3
        arr = new int[]{1};
        k = 1;
        expected = 0;
        actual = test.findLeastNumOfUniqueInts(arr, k);
        System.out.println(expected == actual);
    }
}
