package com.leetcode.dp;

import java.util.Arrays;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 5;
        }
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        int res = 0;
        for (int j = 0; j < 5; j++) {
            res += dp[n - 1][j];
        }
        return res;
    }

//    public int countVowelStrings(int n) {
//        int[][] dp = new int[n + 1][5];
//        Arrays.fill(dp[1], 1);
//
//        // Here i means the length of string we're growing. And 2d index 0 ~4 means the current ending char is a, e, i, o, u.
//        // Current ending char matters, because it determines from where we can start next round.
//        for (int i = 2; i < n + 1; i++) {
//            //  4 refers 'u', 3 refers 'o', etc.
//            dp[i][4] += dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
//            dp[i][3] += dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
//            dp[i][2] += dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
//            dp[i][1] += dp[i - 1][0] + dp[i - 1][1];
//            dp[i][0] += dp[i - 1][0];
//        }
//        //System.out.println(Arrays.deepToString(dp));
//
//        int sum = 0;
//        int[] res = dp[n];
//        for (int num : res) {
//            sum += num;
//        }
//        return sum;
//    }

//    int dp[][];
//
//    public int countVowelStrings(int n) {
//        int numOfLetters = 5;
//        dp = new int[numOfLetters][n + 1];
//        return count(numOfLetters, 0, n);
//    }
//
//    private int count(int numOfLetters, int letterSelected, int n) {
//        if (n == 1)
//            return numOfLetters - letterSelected; //No. of possible combinations
//        if (dp[letterSelected][n] != 0) return dp[letterSelected][n];
//        int ans = 0;
//        for (int j = letterSelected; j < 5; j++)
//            ans += count(numOfLetters, j, n - 1);
//        return dp[letterSelected][n] = ans;
//    }

    public static void main(String[] args) {
        CountSortedVowelStrings test = new CountSortedVowelStrings();
        int n = 1;
        int res = test.countVowelStrings(n);
        System.out.println(res);

        n = 2;
        res = test.countVowelStrings(n);
        System.out.println(res);

        n = 33;
        res = test.countVowelStrings(n);
        System.out.println(res);
    }
}
