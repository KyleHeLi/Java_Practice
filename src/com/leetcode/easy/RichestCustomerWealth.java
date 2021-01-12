package com.leetcode.easy;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int i = 0, length = accounts.length; i < length; i++) {
            int s = sum(accounts[i]);
            if (max < s) {
                max = s;
            }
        }

        return max;
    }

    public int sum(int[] vals) {
        if (vals == null || vals.length == 0) return 0;

        int sum = 0;

        for (int i = 0, length = vals.length; i < length; i++) {
            sum += vals[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        RichestCustomerWealth test = new RichestCustomerWealth();

        // Example 1
        int[][] accounts = new int[][]{{1, 2, 3}, {3, 2, 1}};
        int result = test.maximumWealth(accounts);
        System.out.println(result == 6);

        // Example 2
        accounts = new int[][]{{1, 5}, {7, 3}, {3, 5}};
        result = test.maximumWealth(accounts);
        System.out.println(result == 10);

        // Example 3
        accounts = new int[][]{{1, 2, 3}, {3, 2, 1}};
        result = test.maximumWealth(accounts);
        System.out.println(result == 6);
    }
}
