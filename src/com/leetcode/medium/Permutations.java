package com.leetcode.medium;

import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.List;

// tag: Backtrack
//        result = []
//        def backtrack(路径, 选择列表):
//        if 满足结束条件:
//        result.add(路径)
//        return
//
//        for 选择 in 选择列表:
//        做选择
//        backtrack(路径, 选择列表)
//        撤销选择
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        backtrack(result, new ArrayList<Integer>(), nums);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(result, new ArrayList<Integer>(path), nums);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations test = new Permutations();

        // Example 1
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> result = test.permute(nums);
        System.out.println("[");
        for (List<Integer> i : result) {
            Utils.printIntergerArray(i);
        }
        System.out.println("]");

        // Example 2
        nums = new int[] {0, 1};
        result = test.permute(nums);
        System.out.println("[");
        for (List<Integer> i : result) {
            Utils.printIntergerArray(i);
        }
        System.out.println("]");

        // Example 3
        nums = new int[] {1};
        result = test.permute(nums);
        System.out.println("[");
        for (List<Integer> i : result) {
            Utils.printIntergerArray(i);
        }
        System.out.println("]");
    }
}
