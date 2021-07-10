package com.leetcode.amazon;

import com.leetcode.common.ListNode;

import java.util.PriorityQueue;

// Top Amazon Questions
public class MergeKSortedLists {
    // Better solution with priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        //Create a min heap to hold k nodes
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val-b.val);

        //initialize min heap with first node from each list
        for(int i=0;i<k;i++)
            if(lists[i] != null)
                pq.add(lists[i]);

        //trivial case
        if(pq.isEmpty())
            return null;

        //take the smallest node from min heap, move curr pointer to latest node
        //also add node next to latest node to min heap
        ListNode curr, head;
        curr = pq.poll();
        head = curr;
        if(curr.next != null)
            pq.add(curr.next);

        //repeat same thing in loop till all nodes are processed
        while(!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            if(curr.next != null)
                pq.add(curr.next);
        }

        //return head node
        return head;
    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode result = null;
//        ListNode current = result;
//
//        ListNode[] ptrL = new ListNode[lists.length];
//        for (int i = 0; i < lists.length; i++) {
//            ptrL[i] = lists[i];
//        }
//
//        ListNode min;
//        do {
//            int index = -1;
//            min = null;
//            for (int i = 0; i < lists.length; i++) {
//                if (ptrL[i] != null) {
//                    if (min == null || ptrL[i].val < min.val) {
//                        min = ptrL[i];
//                        index = i;
//                    }
//                }
//            }
//            if (index != -1) {
//                if (result == null) {
//                    result = new ListNode(ptrL[index].val);
//                    current = result;
//
//                } else {
//                    current.next = new ListNode(min.val);
//                    current = current.next;
//                }
//                ptrL[index] = ptrL[index].next;
//            }
//        } while (min != null);
//
//        return result;
//    }

    public static void main(String[] args) {
        MergeKSortedLists test = new MergeKSortedLists();

        // Example 1
        ListNode l1 = new ListNode(new int[]{1, 4, 5});
        ListNode l2 = new ListNode(new int[]{1, 3, 4});
        ListNode l3 = new ListNode(new int[]{2, 6});
        ListNode expected = new ListNode(new int[]{1, 1, 2, 3, 4, 4, 5, 6});
        ListNode result = test.mergeKLists(new ListNode[]{l1, l2, l3});
        System.out.println(expected.equals(result));

        // Example 2
        expected = null;
        result = test.mergeKLists(new ListNode[0]);
        System.out.println(expected == result);

        // Example 3
        expected = null;
        result = test.mergeKLists(new ListNode[]{null});
        System.out.println(expected == result);

    }
}
