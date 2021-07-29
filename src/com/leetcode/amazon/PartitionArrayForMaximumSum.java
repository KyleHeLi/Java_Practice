package com.leetcode.amazon;

// Top Amazon Questions
// tag: DP
public class PartitionArrayForMaximumSum {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        return helper(arr, new int[n], 0, k);
    }

    public int helper(int[] arr, int[] dp, int index, int k) {
        if (index == arr.length) {
            return 0;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        int currentMax = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;

        for (int j = index; j < index + k && j < arr.length; j++) {
            currentMax = Math.max(currentMax, arr[j]);
            result = Math.max(result, currentMax * (j - index + 1) + helper(arr, dp, j + 1, k));
        }

        dp[index] = result;
        return result;
    }

//    public int maxSumAfterPartitioning(int[] arr, int k) {
//        int n = arr.length;
//        int[] dp = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            int curMax = 0;
//            // we can k steps behind to find max value and multiply it with total length
//            for (int j = i - 1; j >= Math.max(0, i - k); j--) {
//                curMax = Math.max(curMax, arr[j]);
//                dp[i] = Math.max(dp[i], dp[j] + curMax * (i - j));
//            }
//        }
//
//        return dp[n];
//    }


    public static void main(String[] args) {
        PartitionArrayForMaximumSum test = new PartitionArrayForMaximumSum();

        // Example 1
        int[] arr = new int[]{1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int expected = 84;
        int actual = test.maxSumAfterPartitioning(arr, k);
        System.out.println(expected == actual);

        // Example 2
        arr = new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        k = 4;
        expected = 83;
        actual = test.maxSumAfterPartitioning(arr, k);
        System.out.println(expected == actual);

        // Example 3
        arr = new int[]{1};
        k = 1;
        expected = 1;
        actual = test.maxSumAfterPartitioning(arr, k);
        System.out.println(expected == actual);

        // Example 4
        arr = new int[]{8, 2, 7, 6, 1};
        k = 2;
        expected = 35;
        actual = test.maxSumAfterPartitioning(arr, k);
        System.out.println(expected == actual);
    }
}
