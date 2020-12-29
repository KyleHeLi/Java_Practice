package com.leetcode.easy;

import java.util.HashMap;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;

        if (nums != null && length > 1) {
            HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < length; i++) {
                if (numMap.containsKey(nums[i])) {
                    return new int[]{numMap.get(nums[i]), i};
                } else {
                    numMap.put(target - nums[i], i);
                }
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum_1 test = new TwoSum_1();

        // Example 1
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] output = test.twoSum(nums, target);
        System.out.println(String.format("[%d, %d]", output[0], output[1]));

        // Example 2
        nums = new int[]{3, 2, 4};
        target = 6;
        output = test.twoSum(nums, target);
        System.out.println(String.format("[%d, %d]", output[0], output[1]));

        // Example 3
        nums = new int[]{3, 3};
        target = 6;
        output = test.twoSum(nums, target);
        System.out.println(String.format("[%d, %d]", output[0], output[1]));
    }
}
