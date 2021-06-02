package com.leetcode.easy;

// tag: DP
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int[][] dp = new int[prices.length+1][prices.length+1];
        int leastPrice = prices[0];

        dp(prices, dp, 1, 2, leastPrice);

        return dp[dp.length-1][dp.length-1];
    }

    private void dp(int[] prices, int[][] dp, int buy, int sell, int leastPrice) {
        if (buy > sell) {
            return;
        }

        if (leastPrice < prices[buy - 1]) {
            leastPrice = prices[buy - 1];
            dp(prices, dp, buy+1, sell+1, leastPrice);
        } else {
            dp[buy][sell] = dp[buy-1][sell-1];
            if (prices[sell - 1] - prices[buy - 1] > dp[buy][sell]) {
                dp[buy][sell] = prices[sell - 1] - prices[buy - 1];
            }

            for (int j = sell + 1; j < prices.length; j++) {
                dp(prices, dp, buy, j, leastPrice);
            }
        }
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII test = new BestTimeToBuyAndSellStockII();
        int[] prices = new int[] {7,1,5,3,6,4};
        int result = test.maxProfit(prices);
        System.out.println(result == 7);

        prices = new int[] {1,2,3,4,5};
        result = test.maxProfit(prices);
        System.out.println(result == 4);

        prices = new int[] {7,6,4,3,1};
        result = test.maxProfit(prices);
        System.out.println(result == 0);
    }
}
