package com.leetcode.medium;

import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    // Better solution
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int index) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; ++i) {
            temp.add(nums[i]);
            backtracking(result, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new LinkedList<List<Integer>>();
//        List<Integer> track = new LinkedList<Integer>();
//        backtrack(nums, track, result);
//        return result;
//    }
//
//    private void backtrack(int[] nums, List<Integer> track, List<List<Integer>> result) {
//        List<Integer> subset = new LinkedList<Integer>();
//        for (Integer i : track) {
//            subset.add(nums[i]);
//        }
//        result.add(subset);
//
//        int start;
//        if (nums.length == subset.size()) {
//            return;
//        } else if (track.size() == 0) {
//            start = 0;
//        } else {
//            start = track.get(track.size()-1) + 1;
//        }
//
//        for (int i = start; i < nums.length; i++) {
//            track.add(i);
//            backtrack(nums, new LinkedList(track), result);
//            track.remove(track.size()-1);
//        }
//    }

    public static void main(String[] args) {
        Subsets test = new Subsets();

        int[] nums = new int[] {1,2,3};
        List<List<Integer>> result = test.subsets(nums);
        System.out.print("[");
        for (List<Integer> elem : result) {
            Utils.printIntergerArray(elem);
        }
        System.out.println("]");

        nums = new int[] {0};
        result = test.subsets(nums);
        System.out.print("[");
        for (List<Integer> elem : result) {
            Utils.printIntergerArray(elem);
        }
        System.out.println("]");
    }
}
