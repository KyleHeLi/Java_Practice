package com.leetcode.medium;

import java.util.*;

public class ThreeSum {
    // Better solution
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        Set<Map.Entry<Integer, Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    Map<Integer, Integer> entrys = new HashMap<>();
                    entrys.put(nums[i], nums[j]);

                    Iterator<Map.Entry<Integer, Integer>> it = entrys.entrySet().iterator();
                    if(!set.contains(it.next())){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        for (Map.Entry<Integer, Integer> it2 : entrys.entrySet()) {
                            set.add(it2);
                        }
                    }
                    j++;
                    k--;
                }
            }
        }

        return res;
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        Map<Integer, Integer> twoSumMap = new HashMap<Integer, Integer>();
//
//        for (int i = 0; i < nums.length; i++) {
//            twoSumMap.put(0 - nums[i], i);
//        }
//
//        Map<String, Boolean> cacheMap = new HashMap<String, Boolean>();
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (twoSumMap.containsKey(nums[i] + nums[j])) {
//                    int k = twoSumMap.get(nums[i] + nums[j]);
//                    int[] key = new int[]{nums[i], nums[j], nums[k]};
//                    Arrays.sort(key);
//                    String s = String.valueOf(key[0]) + String.valueOf(key[1]) + String.valueOf(key[2]);
//                    if (i != j && i != k && j != k && !cacheMap.containsKey(s)) {
//                        List<Integer> r = new ArrayList<Integer>();
//                        r.add(key[0]);
//                        r.add(key[1]);
//                        r.add(key[2]);
//                        result.add(r);
//                        cacheMap.put(s, true);
//                    }
//                }
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();

        // Example 1
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = test.threeSum(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        System.out.println("===============");

        // Example 2
        nums = new int[]{};
        result = test.threeSum(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        System.out.println("===============");

        // Example 3
        nums = new int[]{0};
        result = test.threeSum(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        System.out.println("===============");
    }
}
