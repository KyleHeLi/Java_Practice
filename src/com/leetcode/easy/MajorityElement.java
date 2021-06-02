package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                count++;
            } else {
                if (count > (nums.length / 2)) {
                    return nums[i - 1];
                }
                count = 1;
            }
        }

        if (count > (nums.length / 2)) {
            return nums[nums.length - 1];
        }

        return nums[0];
    }

//    public int majorityElement(int[] nums) {
//        int maxKey = Integer.MIN_VALUE;
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsKey(nums[i])) {
//                map.put(nums[i], 0);
//            }
//
//            map.put(nums[i], map.get(nums[i]) + 1);
//
//            if (!map.containsKey(maxKey) || map.get(nums[i]) > map.get(maxKey)) {
//                maxKey = nums[i];
//            }
//        }
//
//        return maxKey;
//    }

    public static void main(String[] args) {
        MajorityElement test = new MajorityElement();
        int[] nums = new int[] {3, 2, 3};
        System.out.println(test.majorityElement(nums) == 3);

        nums = new int[] {2, 2, 1, 1, 1, 2, 2};
        System.out.println(test.majorityElement(nums) == 2);

        nums = new int[] {3, 3, 4};
        System.out.println(test.majorityElement(nums) == 3);
    }
}
