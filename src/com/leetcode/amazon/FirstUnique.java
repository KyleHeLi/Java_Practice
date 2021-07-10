package com.leetcode.amazon;

import java.util.*;

// Top Amazon Questions
// tag: Queue, Hashmap
public class FirstUnique {

    Queue<Integer> queue;
    Map<Integer, Boolean> uniqueMap;

    public FirstUnique(int[] nums) {
        queue = new LinkedList<>();
        uniqueMap = new HashMap<>();

        if (nums != null && nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && !uniqueMap.get(queue.peek())) {
            queue.remove();
        }
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return -1;
    }

    public void add(int value) {
        if (!uniqueMap.containsKey(value)) {
            queue.add(value);
            uniqueMap.put(value, true);

        } else {
            uniqueMap.put(value, false);
        }

    }

    public static void main(String[] args) {
        // Example 1
        FirstUnique firstUnique = new FirstUnique(new int[]{2, 3, 5});
        int result = firstUnique.showFirstUnique(); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        result = firstUnique.showFirstUnique(); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        result = firstUnique.showFirstUnique(); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        result = firstUnique.showFirstUnique(); // return -1

        // Example 2
        firstUnique = new FirstUnique(new int[]{7, 7, 7, 7, 7, 7});
        result = firstUnique.showFirstUnique(); // return -1
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        result = firstUnique.showFirstUnique(); // return 17

        // Example 3
        firstUnique = new FirstUnique(new int[]{809});
        result = firstUnique.showFirstUnique(); // return 809
        firstUnique.add(809);          // the queue is now [809,809]
        result = firstUnique.showFirstUnique(); // return -1

        // Example 4
        firstUnique = new FirstUnique(new int[]{1});
        result = firstUnique.showFirstUnique(); // return 1
        firstUnique.add(1);            // the queue is now [1, 1]
        firstUnique.add(1);            // the queue is now [1, 1, 1]
        result = firstUnique.showFirstUnique(); // return -1
    }
}
