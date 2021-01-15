package com.leetcode.easy;

import java.util.Arrays;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length];

        for (int i = 0, j = n, k = 0; i < nums.length / 2; i++, j++, k += 2) {
            result[k] = nums[i];
            result[k+1] = nums[j];
        }

        return result;
    }

    public static void main(String[] args) {
        ShuffleTheArray test = new ShuffleTheArray();

        // Example 1
        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        int n = 3;
        int[] result = test.shuffle(nums, n);
        System.out.println(Arrays.equals(result, new int[]{2, 3, 5, 4, 1, 7}));

        // Example 2
        nums = new int[]{1,2,3,4,4,3,2,1};
        n = 4;
        result = test.shuffle(nums, n);
        System.out.println(Arrays.equals(result, new int[]{1,4,2,3,3,2,4,1}));

        // Example 3
        nums = new int[]{1,1,2,2};
        n = 2;
        result = test.shuffle(nums, n);
        System.out.println(Arrays.equals(result, new int[]{1,2,1,2}));
    }
}
