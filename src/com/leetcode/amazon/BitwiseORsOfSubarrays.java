package com.leetcode.amazon;

import java.util.*;

// Top Amazon Questions
// tag: DP
public class BitwiseORsOfSubarrays {
    public int subarrayBitwiseORs(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        Set<Integer> dp = new HashSet();
        Set<Integer> ans = new HashSet();

        dp.add(arr[0]);
        ans.add(arr[0]);
        for (int i = 1; i < n; i++) {
            Set<Integer> newDp = new HashSet();
            newDp.add(arr[i]);
            for (int bitWiseOr : dp) {
                newDp.add(bitWiseOr | arr[i]);
            }
            dp = newDp;
            ans.addAll(dp);
        }


        return ans.size();
    }

    public static void main(String[] args) {
        BitwiseORsOfSubarrays test = new BitwiseORsOfSubarrays();

        // Example 1
        int[] arr = new int[]{0};
        int expected = 1;
        int actual = test.subarrayBitwiseORs(arr);
        System.out.println(actual == expected);

        // Example 2
        arr = new int[]{1, 1, 2};
        expected = 3;
        actual = test.subarrayBitwiseORs(arr);
        System.out.println(actual == expected);

        // Example 3
        arr = new int[]{1, 2, 4};
        expected = 6;
        actual = test.subarrayBitwiseORs(arr);
        System.out.println(actual == expected);
    }
}
