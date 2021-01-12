package com.leetcode.medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;

        int left = 0;
        int right = height.length - 1;

        while (right - left >= 1) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            if (temp > max) max = temp;

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater test = new ContainerWithMostWater();

        // Example 1
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = test.maxArea(height);
        System.out.println(result == 49);

        // Example 2
        height = new int[]{1, 1};
        result = test.maxArea(height);
        System.out.println(result == 1);

        // Example 3
        height = new int[]{4, 3, 2, 1, 4};
        result = test.maxArea(height);
        System.out.println(result == 16);

        // Example 4
        height = new int[]{1, 2, 1};
        result = test.maxArea(height);
        System.out.println(result == 2);
    }
}
