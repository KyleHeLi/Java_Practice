package com.leetcode.medium;

import com.leetcode.common.Utils;

import java.util.*;
import java.util.stream.Collectors;

// tag: backtrack
public class PermutationsII {

    // Better solution
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> allPermute = new ArrayList<>();
        permuteUniqueImpl(nums, 0, allPermute);

        return allPermute;
    }

    public void permuteUniqueImpl(int[] nums, int index, List<List<Integer>> allPermute) {
        if (index == nums.length) {
            List<Integer> newPermute = new ArrayList<>();
            for (int i : nums) {
                newPermute.add(i);
            }
            allPermute.add(newPermute);
            return;
        }
        Set<Integer> curPos = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!curPos.add(nums[i])) continue;
            swap(nums, index, i);
            permuteUniqueImpl(nums, index + 1, allPermute);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        Map<String, Integer> map = new HashMap<String, Integer>();
//
//        backtrack(map, result, new ArrayList<Integer>(), nums);
//
//        return result;
//    }
//
//    private void backtrack(Map<String, Integer> map, List<List<Integer>> result, List<Integer> path, int[] nums) {
//        if (path.size() == nums.length) {
//            String s = path.stream().map(Object::toString).collect(Collectors.joining(""));
//            if (!map.containsKey(s)) {
//                result.add(new ArrayList<Integer>(path));
//                map.put(s, 1);
//            }
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(String.valueOf(i))) {
//                continue;
//            }
//            path.add(nums[i]);
//            map.put(String.valueOf(i), 1);
//            backtrack(map, result, new ArrayList<Integer>(path), nums);
//            path.remove(path.size() - 1);
//            map.remove(String.valueOf(i));
//        }
//    }

    public static void main(String[] args) {
        PermutationsII test = new PermutationsII();

        // Example 1
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> result = test.permuteUnique(nums);
        System.out.print("[");
        for (List<Integer> i : result) {
            Utils.printIntergerArray(i);
        }
        System.out.print("]");

        // Example 2
        nums = new int[]{1, 2, 3};
        result = test.permuteUnique(nums);
        System.out.print("[");
        for (List<Integer> i : result) {
            Utils.printIntergerArray(i);
        }
        System.out.print("]");

        // Example 3
        nums = new int[]{1, 1, 1};
        result = test.permuteUnique(nums);
        System.out.print("[");
        for (List<Integer> i : result) {
            Utils.printIntergerArray(i);
        }
        System.out.print("]");
    }
}
