package com.leetcode.easy;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs test = new MinCostClimbingStairs();

        // Example 1
        int[] cost = new int[]{10, 15, 20};
        int result = test.minCostClimbingStairs(cost);
        System.out.println(result == 15);

        // Example 2
        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        result = test.minCostClimbingStairs(cost);
        System.out.println(result == 6);
    }
}
