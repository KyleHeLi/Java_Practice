package com.leetcode.hard;

public class TwentyFourGame {
    public boolean judgePoint24(int[] nums) {

        return false;
    }

    public static void main(String[] args) {
        TwentyFourGame test = new TwentyFourGame();

        // Example 1
        int[] nums = new int[] {4, 1, 8, 7};
        boolean result = test.judgePoint24(nums);
        System.out.println(result = true);

        // Example 2
        nums = new int[] {1, 2, 1, 2};
        result = test.judgePoint24(nums);
        System.out.println(result = false);
    }
}
