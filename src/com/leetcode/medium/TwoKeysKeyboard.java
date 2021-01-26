package com.leetcode.medium;

public class TwoKeysKeyboard {
    public int minSteps(int n) {
        if (n <= 1) {
            return 0;
        }

        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = 2 + dp[i/2];
            } else {
                for (int j = 3; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        dp[i] = dp[i / j] + j;
                        break;
                    }
                }
                if (dp[i] == 0) {
                    dp[i] = i;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        TwoKeysKeyboard test = new TwoKeysKeyboard();

        // Example 1
        int n = 3;
        int result = test.minSteps(n);
        System.out.println(result == 3);

        // Example 2
        n = 10;
        result = test.minSteps(n);
        System.out.println(result == 7);
    }
}
