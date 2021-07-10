package com.leetcode.amazon;

import sun.reflect.generics.tree.Tree;

import java.util.*;

// Top Amazon Questions
// tag: Heap (Priority Queue)
public class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        maxHeap.add(num);

        minHeap.add(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (double) (maxHeap.peek() + minHeap.peek()) / 2;
    }

    public static void main(String[] args) {
        // Example 1
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        double result = medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        result = medianFinder.findMedian(); // return 2.0
    }
}
