package com.leetcode.dp;

public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciNumber test = new FibonacciNumber();
        int n = 2;
        int res = test.fib(n);
        System.out.println(res);

        n = 3;
        res = test.fib(n);
        System.out.println(res);

        n = 4;
        res = test.fib(n);
        System.out.println(res);
    }
}
