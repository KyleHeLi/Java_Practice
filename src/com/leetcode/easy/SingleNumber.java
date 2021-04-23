package com.leetcode.easy;

import java.util.*;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            if (i + 1 >= nums.length || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return Integer.MIN_VALUE;
    }

//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, 0);
//            }
//            map.put(num, map.get(num) + 1);
//        }
//
//        int result = Integer.MIN_VALUE;
//
//        for (int key : map.keySet()) {
//            if (map.get(key) == 1) {
//                result = key;
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        SingleNumber test = new SingleNumber();
        int[] nums = new int[] {2, 2, 1};
        System.out.println(test.singleNumber(nums) == 1);

        nums = new int[] {4, 1, 2, 1, 2};
        System.out.println(test.singleNumber(nums) == 4);

        nums = new int[] {1};
        System.out.println(test.singleNumber(nums) == 1);
    }
}
