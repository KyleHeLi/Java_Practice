package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LRUCache {

    private int capacity;
    private Map<Integer, Integer> cacheMap;
    private int[][] minHeap;
    private int index;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<Integer, Integer>();
        minHeap = new int[capacity][2];
        index = 0;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }

        // TODO: add a counter to get the key
        for (int i = 0; i < index; i++) {
            if (minHeap[i][0] == key) {
                minHeap[i][1]++;
                minHeapify(i);
            }
        }

        return cacheMap.get(key);
    }

    private boolean isLeaf(int pos) {
        if (pos >= (index / 2) && pos <= index) {
            return true;
        }
        return false;
    }

    private void minHeapify(int i) {
        // Arr[(i -1) / 2] returns its parent node.
        // Arr[(2 * i) + 1] returns its left child node.
        // Arr[(2 * i) + 2] returns its right child node
        while (i < index) {
            // index 0 represents the key
            // index 1 represents the used count
            int[] current = minHeap[i];
            int[] left = null, right = null;
            if ((2 * i) + 1 < index) {
                left = minHeap[(2 * i) + 1];
            }
            if ((2 * i) + 2 < index) {
                right = minHeap[(2 * i) + 2];
            }

            if (!(left == null && right == null)) {
                if (current == null || current[1] > left[1] || current[1] > right[1]) {
                    if (left[1] > right[1]) {
                        swap(i, (2 * i) + 2);
                        minHeapify((2 * i) + 2);
                    } else {
                        swap(i, (2 * i) + 1);
                        minHeapify((2 * i) + 1);
                    }
                }
            } else if (left == null) {

            } else if (right == null) {

            }

        }
    }

    private void swap(int fpos, int spos)
    {
        int[] tmp;
        tmp = minHeap[fpos];
        minHeap[fpos] = minHeap[spos];
        minHeap[spos] = tmp;
    }

    public void put(int key, int value) {
        if (index < capacity) {
            int i = index;
            cacheMap.put(key, value);
            // index 0 represents the key
            // index 1 represents the used count
            minHeap[i] = new int[] {key, 0};
            while(minHeap[i][1] < minHeap[(i - 1) / 2][1]) {
                swap(i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
            index++;
        } else {
            // TODO: remove the least used unit
            int[] min = minHeap[0];
            cacheMap.remove(min[0]);
            cacheMap.put(key, value);
            int i = index;
            minHeap[i] = new int[] {key, 0};
            while(minHeap[i][1] < minHeap[(i - 1) / 2][1]) {
                swap(i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (Integer key : cacheMap.keySet()) {
            sb.append(key + "=" + cacheMap.get(key) + ", ");
        }

        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
        System.out.println(lRUCache);
    }
}
