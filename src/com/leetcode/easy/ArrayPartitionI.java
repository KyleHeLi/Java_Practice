package com.leetcode.easy;

import java.util.Arrays;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += Math.min(nums[i], nums[i+1]);
        }

        return sum;
    }

    public static void main(String[] args) {
        ArrayPartitionI test = new ArrayPartitionI();

        // Example 1
        int[] nums = new int[]{1, 4, 3, 2};
        System.out.println(test.arrayPairSum(nums) == 4);

        // Example 2
        nums = new int[]{6, 2, 6, 5, 1, 2};
        System.out.println(test.arrayPairSum(nums) == 9);
    }
}
