package com.leetcode.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Top Amazon Questions
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        if (nums != null) {
            for (int i = 0; i < nums.length; i++) {
                if (!numsMap.containsKey(nums[i])) {
                    numsMap.put(target - nums[i], i);
                } else {
                    return new int[]{numsMap.get(nums[i]), i};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 5};
        int target = 9;
        int[] expected = new int[]{0, 1};
        int[] result = test.twoSum(nums, target);
        System.out.println(Arrays.equals(expected, result));

        nums = new int[]{3, 2, 4};
        target = 6;
        expected = new int[]{1, 2};
        result = test.twoSum(nums, target);
        System.out.println(Arrays.equals(expected, result));

        nums = new int[]{3, 3};
        target = 6;
        expected = new int[]{0, 1};
        result = test.twoSum(nums, target);
        System.out.println(Arrays.equals(expected, result));
    }
}
