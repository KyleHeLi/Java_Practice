package com.leetcode.amazon;

import java.util.HashMap;
import java.util.Map;

// Top Amazon Questions
// Tag: hashmap
public class FourSumCountII {
    // Approach 1: Hashmap
    // Algorithm
    //    1. For each a in A.
    //          For each b in B.
    //              If a + b exists in the hashmap m, increment the value.
    //              Else add a new key a + b with the value 1.
    //
    //    2. For each c in C.
    //          For each d in D.
    //              Lookup key -(c + d) in the hashmap m.
    //              Add its value to the count cnt.
    //
    //    3. Return the count cnt.
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                count += map.getOrDefault(-(nums3[i] + nums4[j]), 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FourSumCountII test = new FourSumCountII();

        // Example 1
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2, -1};
        int[] nums3 = new int[]{-1, 2};
        int[] nums4 = new int[]{0, 2};
        int expected = 2;
        int actual = test.fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(expected == actual);

        // Example 2
        nums1 = new int[]{0};
        nums2 = new int[]{0};
        nums3 = new int[]{0};
        nums4 = new int[]{0};
        expected = 1;
        actual = test.fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(expected == actual);

    }
}

// Solution
//Approach 2: kSum II
//    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//      return kSumCount(new int[][]{A, B, C, D});
//    }
//    public int kSumCount(int[][] lists) {
//        Map<Integer, Integer> m = new HashMap<>();
//        addToHash(lists, m, 0, 0);
//        return countComplements(lists, m, lists.length / 2, 0);
//    }
//    void addToHash(int[][] lists, Map<Integer, Integer> m, int i, int sum) {
//        if (i == lists.length / 2)
//            m.put(sum, m.getOrDefault(sum, 0) + 1);
//        else
//            for (int a : lists[i])
//                addToHash(lists, m, i + 1, sum + a);
//    }
//    int countComplements(int[][] lists, Map<Integer, Integer> m, int i, int complement) {
//        if (i == lists.length)
//            return m.getOrDefault(complement, 0);
//        int cnt = 0;
//        for (int a : lists[i])
//            cnt += countComplements(lists, m, i + 1, complement - a);
//        return cnt;
//    }