package com.leetcode.amazon;

import java.util.*;

// Top Amazon Question
// tag: Priority Queue, Min-Heap
public class MeetingRoomII {

    // clean solution
    public int minMeetingRooms2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek()[1] <= interval[0]) {
                pq.poll();
            }
            pq.add(interval);
        }
        return pq.size();
    }

    // Time complexity: O(N log N)
    public int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return 0;
        }

        // Sort the intervals by start tim
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // Min heap, use the end time to be the value
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }

    public static void main(String[] args) {
        MeetingRoomII test = new MeetingRoomII();

        // Example 1
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int expected = 2;
        int actual = test.minMeetingRooms(intervals);
        System.out.println(expected == actual);

        // Example 2
        intervals = new int[][]{{7, 10}, {2, 4}};
        expected = 1;
        actual = test.minMeetingRooms(intervals);
        System.out.println(expected == actual);

        // Example 3
        intervals = new int[][]{{13, 15}, {1, 13}};
        expected = 1;
        actual = test.minMeetingRooms(intervals);
        System.out.println(expected == actual);

        // Example 4
        intervals = new int[][]{{9, 10}, {4, 9}, {4, 17}};
        expected = 2;
        actual = test.minMeetingRooms(intervals);
        System.out.println(expected == actual);
    }
}

// Solutions:
// Approach 1 -
//Algorithm
//
// 1. Sort the given meetings by their start time.
// 2. Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
// 3. For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
// 4. If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
// 5. If not, then we allocate a new room and add it to the heap.
// 6. After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.