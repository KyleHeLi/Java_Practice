package com.leetcode.easy;

// tag: DP
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        int leastPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > leastPrice && prices[i] - leastPrice > profit) {
                profit = prices[i] - leastPrice;
            } else if (prices[i] < leastPrice) {
                leastPrice = prices[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();

        // Example 1
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        int result = test.maxProfit(prices);
        System.out.println(result == 5);

        // Example 2
        prices = new int[] {7, 6, 4, 3, 1};
        result = test.maxProfit(prices);
        System.out.println(result == 0);
    }
}
