package com.leetcode.dp;

public class DivisorGame {

    public boolean divisorGame(int n) {
        //dp[i] -> can a player (whose turn is current) win with val 'i'
        boolean[] dp = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                //dp[i-j] == false, checks if the opponent loses with 'i-j'
                if ((i % j == 0) && (dp[i - j] == false)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

//    public boolean divisorGame(int n) {
//        if (n % 2 == 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public static void main(String[] args) {
        DivisorGame test = new DivisorGame();
        int n = 2;
        boolean res = test.divisorGame(n);
        System.out.println(res);

        n = 3;
        res = test.divisorGame(n);
        System.out.println(res);
    }
}
