package com.leetcode.amazon;

import java.util.Deque;
import java.util.LinkedList;

// Amazon Top Questions
// tag: DP
public class MinimumDifficultyOfAJobSchedule {

    // Explanation
//    First of all, we should use dp. And intuitively, we should use a 2d-array.
//    The cell dp[i][j] means that the result of dividing arr[0...j] (inclusively) into i days.
//
//    1. Initialize the first row. Set each cell simply as the maximum of each subarry arr[0...j].
//    2. For each line next, for each cell dp[i][j], we need to find the immediate larger item to the left of it.
//            e.g., say jobDifficulty = [...30,10,20...].
//    For the difficulty of 20, we do not need to care about anything before 30 (because of dp).
//    All we need to do is to find the smallest result between dp[i - 1][index of 30] + 20, dp[i - 1][index of 10] + 20. This is a simple loop. We name the result as temp.
//    Therefore, we need a deque to store the longest non-increasing subsequence.
//    3. The equation is that dp[i][j] = min(dp[i][index of 30], temp), where the first item is the difficulty that we merge all the days after 30 into it; and the second item is that we put some of them into a new day.

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;
        int[][] dp = new int[d][n];
        dp[0][0] = jobDifficulty[0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], jobDifficulty[j]);
        }
        for (int i = 1; i < d; i++) {
            Deque<Integer> indices = new LinkedList<>();
            for (int j = i; j < n; j++) {
                int diff = jobDifficulty[j];
                while (!indices.isEmpty() && jobDifficulty[indices.peekLast()] < diff) indices.pollLast();
                int temp = Integer.MAX_VALUE;
                for (int k = (indices.isEmpty() ? i - 1 : indices.peekLast()); k < j; k++) {
                    temp = Math.min(temp, dp[i - 1][k] + diff);
                }
                int merge = (indices.isEmpty() ? Integer.MAX_VALUE : dp[i][indices.peekLast()]);
                dp[i][j] = Math.min(temp, merge);
                indices.addLast(j);
            }
        }
        return dp[d - 1][n - 1];
    }

    public static void main(String[] args) {
        MinimumDifficultyOfAJobSchedule test = new MinimumDifficultyOfAJobSchedule();

        // Example 1
        int[] jobDifficulty = new int[]{6, 5, 4, 3, 2, 1};
        int d = 2;
        int expected = 7;
        int actual = test.minDifficulty(jobDifficulty, d);
        System.out.println(expected == actual);

        // Example 2
        jobDifficulty = new int[]{9, 9, 9};
        d = 4;
        expected = -1;
        actual = test.minDifficulty(jobDifficulty, d);
        System.out.println(expected == actual);

        // Example 3
        jobDifficulty = new int[]{1, 1, 1};
        d = 3;
        expected = 3;
        actual = test.minDifficulty(jobDifficulty, d);
        System.out.println(expected == actual);

        // Example 4
        jobDifficulty = new int[]{7, 1, 7, 1, 7, 1};
        d = 3;
        expected = 15;
        actual = test.minDifficulty(jobDifficulty, d);
        System.out.println(expected == actual);

        // Example 5
        jobDifficulty = new int[]{11, 111, 22, 222, 33, 333, 44, 444};
        d = 6;
        expected = 843;
        actual = test.minDifficulty(jobDifficulty, d);
        System.out.println(expected == actual);
    }
}
