package com.leetcode.medium;

import com.leetcode.common.Utils;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            String s = sort(str);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(str);
        }

        List<List<String>> groups = new ArrayList<List<String>>();

        map.forEach((k, v) -> groups.add(v));

        return groups;
    }

    private static String sort(String input) {
        if (input == null) return null;

        char[] arrayToSort = input.toCharArray();
        Arrays.sort(arrayToSort);

        return new String(arrayToSort);
    }

    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();

        // Example 1
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = test.groupAnagrams(strs);
        result.forEach((lst) -> Utils.printStringArray(lst));
        System.out.println("=======================");

        // Example 2
        strs = new String[]{""};
        result = test.groupAnagrams(strs);
        result.forEach((lst) -> Utils.printStringArray(lst));
        System.out.println("=======================");

        // Example 3
        strs = new String[]{"a"};
        result = test.groupAnagrams(strs);
        result.forEach((lst) -> Utils.printStringArray(lst));
        System.out.println("=======================");
    }
}
