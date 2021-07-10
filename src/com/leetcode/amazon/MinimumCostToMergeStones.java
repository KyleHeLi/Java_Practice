package com.leetcode.amazon;

// Amazon Top Questions
// tag: DP
public class MinimumCostToMergeStones {
    int psum[];

    public int mergeStones(int[] nums, int k) {
        int n = nums.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        psum = new int[n];

        psum[0] = nums[0];

        for (int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + nums[i];
        }

        int dp[][] = new int[n][n];

        for (int len = k; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int z = i; z < j; z += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][z] + dp[z + 1][j]);
                }

                if ((len - 1) % (k - 1) == 0) {
                    dp[i][j] += psum[j] - (i > 0 ? psum[i - 1] : 0);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        MinimumCostToMergeStones test = new MinimumCostToMergeStones();

        // Example 1
        int[] stones = new int[]{3, 2, 4, 1};
        int k = 2;
        int expected = 20;
        int actual = test.mergeStones(stones, k);
        System.out.println(expected == actual);

        // Example 2
        stones = new int[]{3, 2, 4, 1};
        k = 3;
        expected = -1;
        actual = test.mergeStones(stones, k);
        System.out.println(expected == actual);

        // Example 2
        stones = new int[]{3, 5, 1, 2, 6};
        k = 3;
        expected = 25;
        actual = test.mergeStones(stones, k);
        System.out.println(expected == actual);
    }
}
