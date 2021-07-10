package com.leetcode.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (boxTypes == null || boxTypes.length == 0 || truckSize == 0) {
            return 0;
        }

        int result = 0;
        int rest = truckSize;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int i = 0; i < boxTypes.length; i++) {
            int num = Math.min(rest, boxTypes[i][0]);
            result += num * boxTypes[i][1];
            rest -= num;
            if (rest == 0) break;
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumUnitsOnATruck test = new MaximumUnitsOnATruck();

        // Example 1
        int[][] boxTypes = new int[][]{{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        int expected = 8;
        int actual = test.maximumUnits(boxTypes, truckSize);
        System.out.println(expected == actual);

        // Example 2
        boxTypes = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        truckSize = 10;
        expected = 91;
        actual = test.maximumUnits(boxTypes, truckSize);
        System.out.println(expected == actual);
    }
}
