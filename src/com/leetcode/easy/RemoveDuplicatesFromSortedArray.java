package com.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int exchangeNum = 0;
        int i = 0;
        int j = i;
        while (i < nums.length - 1 && j < nums.length - 1) {
            if (nums[j] == nums[j + 1]) {
                exchangeNum++;
            } else {
                nums[i + 1] = nums[j + 1];
                i++;
            }

            j++;
        }

        return nums.length - exchangeNum;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray test = new RemoveDuplicatesFromSortedArray();

        // Example 1
        int[] nums = new int[]{1, 1, 2};
        int result = test.removeDuplicates(nums);
        System.out.println(nums);
        System.out.println(result == 2);

        // Example 2
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        result = test.removeDuplicates(nums);
        System.out.println(nums);
        System.out.println(result == 5);
    }
}
