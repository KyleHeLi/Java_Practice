package com.leetcode.amazon;

import java.util.*;
import java.util.stream.Collectors;

// Top Amazon Questions
// Tags: Hash Table, Doubly-linked List
public class LRUCache {
    private Queue<Integer> cache;
    private Map<Integer, Integer> cacheMap;
    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new ArrayDeque<>();
        cacheMap = new HashMap<>();
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            cache.remove(key);
            cache.offer(key);
            return cacheMap.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (!cacheMap.containsKey(key)) {
            if (cache.size() == capacity) {
                int LRUKey = cache.poll();
                cacheMap.remove(LRUKey);
            }
        } else {
            cache.remove(key);
        }
        cache.offer(key);
        cacheMap.put(key, value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        Object[] keys = cacheMap.keySet().toArray();
        for (int i = 0; i < keys.length; i++) {
            sb.append(keys[i] + "=" + cacheMap.get(keys[i]));
            if (i + 1 < keys.length) {
                sb.append(", ");
            }
        }

        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));   // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
        System.out.println(lRUCache);
    }

    // Solutions from leetcode
    // 1. Ordered dictionary
//    class LRUCache extends LinkedHashMap<Integer, Integer>{
//        private int capacity;
//
//        public LRUCache(int capacity) {
//            super(capacity, 0.75F, true);
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            return super.getOrDefault(key, -1);
//        }
//
//        public void put(int key, int value) {
//            super.put(key, value);
//        }
//
//        @Override
//        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//            return size() > capacity;
//        }
//    }

    // 2. Hashmap + DoubleLinkedList
//    public class LRUCache {
//
//        class DLinkedNode {
//            int key;
//            int value;
//            DLinkedNode prev;
//            DLinkedNode next;
//        }
//
//        private void addNode(DLinkedNode node) {
//            /**
//             * Always add the new node right after head.
//             */
//            node.prev = head;
//            node.next = head.next;
//
//            head.next.prev = node;
//            head.next = node;
//        }
//
//        private void removeNode(DLinkedNode node){
//            /**
//             * Remove an existing node from the linked list.
//             */
//            DLinkedNode prev = node.prev;
//            DLinkedNode next = node.next;
//
//            prev.next = next;
//            next.prev = prev;
//        }
//
//        private void moveToHead(DLinkedNode node){
//            /**
//             * Move certain node in between to the head.
//             */
//            removeNode(node);
//            addNode(node);
//        }
//
//        private DLinkedNode popTail() {
//            /**
//             * Pop the current tail.
//             */
//            DLinkedNode res = tail.prev;
//            removeNode(res);
//            return res;
//        }
//
//        private Map<Integer, DLinkedNode> cache = new HashMap<>();
//        private int size;
//        private int capacity;
//        private DLinkedNode head, tail;
//
//        public LRUCache(int capacity) {
//            this.size = 0;
//            this.capacity = capacity;
//
//            head = new DLinkedNode();
//            // head.prev = null;
//
//            tail = new DLinkedNode();
//            // tail.next = null;
//
//            head.next = tail;
//            tail.prev = head;
//        }
//
//        public int get(int key) {
//            DLinkedNode node = cache.get(key);
//            if (node == null) return -1;
//
//            // move the accessed node to the head;
//            moveToHead(node);
//
//            return node.value;
//        }
//
//        public void put(int key, int value) {
//            DLinkedNode node = cache.get(key);
//
//            if(node == null) {
//                DLinkedNode newNode = new DLinkedNode();
//                newNode.key = key;
//                newNode.value = value;
//
//                cache.put(key, newNode);
//                addNode(newNode);
//
//                ++size;
//
//                if(size > capacity) {
//                    // pop the tail
//                    DLinkedNode tail = popTail();
//                    cache.remove(tail.key);
//                    --size;
//                }
//            } else {
//                // update the value.
//                node.value = value;
//                moveToHead(node);
//            }
//        }
//    }
}
