package com.leetcode.medium;

import com.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();

        // Example
        int n = 3;
        int result = test.numTrees(n);
        System.out.println(result == 5);
    }
}
