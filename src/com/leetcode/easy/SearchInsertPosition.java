package com.leetcode.easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = 0;
        int max = nums.length - 1;
        int mid = (min + max) / 2;

        while (min <= max) {
            mid = (min + max) / 2;

            if (target == nums[mid]) {
                break;
            } else if (target < nums[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        if (min > max) {
            return min;
        }

        return mid;
    }

    public static void main(String[] args) {
        SearchInsertPosition test = new SearchInsertPosition();

        // Example 1
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;
        int result = test.searchInsert(nums, target);
        System.out.println(result == 2);

        // Example 2
        nums = new int[]{1, 3, 5, 6};
        target = 2;
        result = test.searchInsert(nums, target);
        System.out.println(result == 1);

        // Example 3
        nums = new int[]{1, 3, 5, 6};
        target = 7;
        result = test.searchInsert(nums, target);
        System.out.println(result == 4);

        // Example 4
        nums = new int[]{1, 3, 5, 6};
        target = 0;
        result = test.searchInsert(nums, target);
        System.out.println(result == 0);

        // Example 2
        nums = new int[]{1};
        target = 0;
        result = test.searchInsert(nums, target);
        System.out.println(result == 0);
    }
}
