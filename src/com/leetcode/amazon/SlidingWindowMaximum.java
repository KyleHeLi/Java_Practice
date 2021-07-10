package com.leetcode.amazon;


import java.util.*;

// Top Amazon Questions
// tag: priority queue, dequeue, array, sliding window
public class SlidingWindowMaximum {

    // O(n), min-heap
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        Deque<Integer> dq = new LinkedList<>();

        int ans[] = new int[n-k+1];

        //Calculate for first window
        for(int i=0;i<k;i++) {

            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) {

                dq.removeLast();

            }
            dq.addLast(i);
        }
        int j = 0;
        for(int i=k;i<n;i++) {

            ans[j++] = nums[dq.peekFirst()];

            while(!dq.isEmpty() && dq.peekFirst()<=i-k) {

                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) {

                dq.removeLast();
            }

            dq.addLast(i);
        }

        ans[j++] = nums[dq.peekFirst()];

        return ans;
    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k < 1 || nums.length < k) {
//            return new int[0];
//        }
//
//        int[] result = new int[nums.length + 1 - k];
//
//        // O(n*k)
//        for (int i = 0; i < result.length; i++) {
//            result[i] = findMax(nums, i, i + k);
//        }
//
//        return result;
//    }
//
//    private int findMax(int[] arr, int begin, int end) {
//        int result = Integer.MIN_VALUE;
//
//        for (int i = begin; i < end; i++) {
//            if (arr[i] > result) {
//                result = arr[i];
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        SlidingWindowMaximum test = new SlidingWindowMaximum();

        // Example 1
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = new int[]{3, 3, 5, 5, 6, 7};
        int[] actual = test.maxSlidingWindow(nums, k);
        System.out.println(Arrays.equals(expected, actual));

        // Example 2
        nums = new int[]{1};
        k = 1;
        expected = new int[]{1};
        actual = test.maxSlidingWindow(nums, k);
        System.out.println(Arrays.equals(expected, actual));

        // Example 3
        nums = new int[]{1, -1};
        k = 1;
        expected = new int[]{1, -1};
        actual = test.maxSlidingWindow(nums, k);
        System.out.println(Arrays.equals(expected, actual));

        // Example 4
        nums = new int[]{9, 11};
        k = 2;
        expected = new int[]{11};
        actual = test.maxSlidingWindow(nums, k);
        System.out.println(Arrays.equals(expected, actual));

        // Example 5
        nums = new int[]{4, -2};
        k = 2;
        expected = new int[]{4};
        actual = test.maxSlidingWindow(nums, k);
        System.out.println(Arrays.equals(expected, actual));
    }
}

// Solution
// Algorithm
// The algorithm is quite straigthforward :
//      Process the first k elements separately to initiate the deque.
//      Iterate over the array. At each step :
//          Clean the deque :
//              Keep only the indexes of elements from the current sliding window.
//              Remove indexes of all elements smaller than the current one, since they will not be the maximum ones.
//          Append the current element to the deque.
//          Append deque[0] to the output.
//          Return the output array.

//class Solution {
//    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
//    int [] nums;
//
//    public void clean_deque(int i, int k) {
//        // remove indexes of elements not from sliding window
//        if (!deq.isEmpty() && deq.getFirst() == i - k)
//            deq.removeFirst();
//
//        // remove from deq indexes of all elements
//        // which are smaller than current element nums[i]
//        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) deq.removeLast();
//    }
//
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        if (n * k == 0) return new int[0];
//        if (k == 1) return nums;
//
//        // init deque and output
//        this.nums = nums;
//        int max_idx = 0;
//        for (int i = 0; i < k; i++) {
//            clean_deque(i, k);
//            deq.addLast(i);
//            // compute max in nums[:k]
//            if (nums[i] > nums[max_idx]) max_idx = i;
//        }
//        int [] output = new int[n - k + 1];
//        output[0] = nums[max_idx];
//
//        // build output
//        for (int i  = k; i < n; i++) {
//            clean_deque(i, k);
//            deq.addLast(i);
//            output[i - k + 1] = nums[deq.getFirst()];
//        }
//        return output;
//    }
//}