package com.leetcode.amazon;

import java.util.HashSet;
import java.util.Set;

// Amazon Top Questions
// tag: math
public class ConsecuritveNumbersSum {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        // x > 0 --> N/k - (k + 1)/2 > 0
        int upper_limit = (int)(Math.sqrt(2 * n + 0.25) - 0.5);
        for (int k = 1; k <= upper_limit; ++k) {
            // x should be an integer
            if ((n - k * (k + 1) / 2) % k == 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ConsecuritveNumbersSum test = new ConsecuritveNumbersSum();

        // Example 1
        int n = 5;
        int expected = 2; // 5 = 2 + 3
        int actual = test.consecutiveNumbersSum(n);
        System.out.println(expected == actual);

        // Example 2
        n = 9;
        expected = 3; // 9 = 4 + 5 = 2 + 3 + 4
        actual = test.consecutiveNumbersSum(n);
        System.out.println(expected == actual);

        // Example 3
        n = 15;
        expected = 4; // 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
        actual = test.consecutiveNumbersSum(n);
        System.out.println(expected == actual);
    }
}
