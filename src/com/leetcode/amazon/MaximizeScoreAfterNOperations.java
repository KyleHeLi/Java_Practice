package com.leetcode.amazon;

import java.util.Arrays;

// Top Amazon Questions
// tag: DP, bitmasking, Euclidean algorithm
public class MaximizeScoreAfterNOperations {
    int[] map;
    int[][] dp;

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int maxScore(int[] nums) {
        map = new int[16384];
        Arrays.fill(map, -1);
        dp = new int[nums.length][nums.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp[0].length; j++) {
                dp[i][j] = gcd(nums[i], nums[j]);
            }
        }
        return find(nums, 0, 1);
    }

    public int find(int[] nums, int mask, int idx) {
        if (map[mask] != -1) return map[mask];
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = (1 << i) + (1 << j);
                if ((mask & a) == 0) {
                    ans = Math.max(ans, idx * dp[i][j] + find(nums, mask | a, idx + 1));
                }
            }
        }
        map[mask] = ans;
        return ans;
    }
}
