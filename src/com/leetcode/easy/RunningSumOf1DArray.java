package com.leetcode.easy;

import java.util.Arrays;

public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        RunningSumOf1DArray test = new RunningSumOf1DArray();

        // Example1
        int[] nums = new int[]{1, 2, 3, 4};
        int[] t = test.runningSum(nums);
        System.out.println(Arrays.equals(t, new int[]{1, 3, 6, 10}));

        // Example2
        nums = new int[]{1, 1, 1, 1, 1};
         t = test.runningSum(nums);
        System.out.println(Arrays.equals(t, new int[]{1, 2, 3, 4, 5}));

        // Example4
        nums = new int[]{3, 1, 2, 10, 1};
        t = test.runningSum(nums);
        System.out.println(Arrays.equals(t, new int[]{3, 4, 6, 16, 17}));
    }
}
