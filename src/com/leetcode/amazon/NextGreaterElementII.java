package com.leetcode.amazon;

import java.util.Arrays;
import java.util.Stack;

// Top Amazon Questions
// tag: Stack
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            result[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementII test = new NextGreaterElementII();

        // Example 1
        int[] nums = new int[]{1, 2, 1};
        int[] expected = new int[]{2, -1, 2};
        int[] actual = test.nextGreaterElements(nums);
        System.out.println(Arrays.equals(expected, actual));

        // Example 2
        nums = new int[]{1, 2, 3, 4, 3};
        expected = new int[]{2, 3, 4, -1, 4};
        actual = test.nextGreaterElements(nums);
        System.out.println(Arrays.equals(expected, actual));
    }
}
