package com.leetcode.easy;

import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = max(candies);

        List<Boolean> result = new ArrayList<Boolean>();

        for (int i = 0, length = candies.length; i < length; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

    public int max(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }

        int max = 0;

        for (int i = 0, length = candies.length; i < length; i++) {
            if (max < candies[i]) {
                max = candies[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies test = new KidsWithTheGreatestNumberOfCandies();

        // Example 1
        int[] candies = new int[]{2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> kids = test.kidsWithCandies(candies, extraCandies);
        Utils.printBooleanArray(kids);

        // Example 2
        candies = new int[]{4, 2, 1, 1, 2};
        extraCandies = 1;
        kids = test.kidsWithCandies(candies, extraCandies);
        Utils.printBooleanArray(kids);

        // Example 3
        candies = new int[]{12, 1, 12};
        extraCandies = 10;
        kids = test.kidsWithCandies(candies, extraCandies);
        Utils.printBooleanArray(kids);
    }
}
