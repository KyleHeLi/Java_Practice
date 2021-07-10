package com.leetcode.amazon;

// Top Amazon Questions
public class TrappingRainWater {

    // Search with note
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int len = height.length;
        int result = 0;

        int[] leftMaxArr = new int[len];
        int[] rightMaxArr = new int[len];
        leftMaxArr[0] = height[0];
        rightMaxArr[len-1] = height[len-1];

        // search the left max
        for (int i = 1; i < len; i++) {
            leftMaxArr[i] = Math.max(height[i], leftMaxArr[i-1]);
        }

        // search the right max
        for (int i = len - 2; i >= 0; i--) {
            rightMaxArr[i] = Math.max(height[i], rightMaxArr[i+1]);
        }

        for (int i = 1; i < len - 1; i++){
            result += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }

        return result;
    }

//    // Brute force
//    public int trap(int[] height) {
//        int len = height.length;
//        int result = 0;
//        for (int i = 1; i < len - 1; i++) {
//            int leftMax = 0;
//            int rightMax = 0;
//
//            // check left max
//            for (int j = i; j >= 0; j--) {
//                if (leftMax < height[j]) {
//                    leftMax = height[j];
//                }
//            }
//
//            // check right max
//            for (int j = i; j < len; j++) {
//                if (rightMax < height[j]) {
//                    rightMax = height[j];
//                }
//            }
//
//            result += Math.min(leftMax, rightMax) - height[i];
//        }
//        return result;
//    }

    public static void main(String[] args) {
        TrappingRainWater test = new TrappingRainWater();

        // Example 1
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;
        int actual = test.trap(height);
        System.out.println(expected == actual);

        // Example 2
        height = new int[]{4, 2, 0, 3, 2, 5};
        expected = 9;
        actual = test.trap(height);
        System.out.println(expected == actual);
    }
}
