package com.leetcode.medium;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1] + 1];
        for (int i = 1, j = 0; i < dp.length; i++) {
            if (i != days[j]) {
                dp[i] = dp[i-1];
                continue;
            }

            dp[i] = dp[i-1] + costs[0];
            dp[i] = Math.min(dp[i], dp[Math.max(i-7, 0)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(i-30, 0)] + costs[2]);
            j++;
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        MinimumCostForTickets test = new MinimumCostForTickets();

        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] costs = new int[]{2, 7, 15};
        System.out.println(test.mincostTickets(days, costs) == 11);

        days = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        costs = new int[]{2, 7, 15};
        System.out.println(test.mincostTickets(days, costs) == 17);
    }
}
