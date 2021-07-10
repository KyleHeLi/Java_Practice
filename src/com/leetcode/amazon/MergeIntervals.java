package com.leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.get(list.size() - 1)[1] >= intervals[i][0]) {
                list.get(list.size() - 1)[1] = Math.max(intervals[i][1], list.get(list.size() - 1)[1]);
            } else {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }

        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals test = new MergeIntervals();

        // Example 1
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        int[][] actual = test.merge(intervals);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(Arrays.equals(expected[i], actual[i]));
        }


        // Example 2
        intervals = new int[][]{{1, 4}, {4, 5}};
        expected = new int[][]{{1, 5}};
        actual = test.merge(intervals);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(Arrays.equals(expected[i], actual[i]));
        }

        // Example 3
        intervals = new int[][]{{1, 4}, {0, 4}};
        expected = new int[][]{{0, 4}};
        actual = test.merge(intervals);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(Arrays.equals(expected[i], actual[i]));
        }

        // Example 3
        intervals = new int[][]{{1, 4}, {2, 3}};
        expected = new int[][]{{1, 4}};
        actual = test.merge(intervals);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(Arrays.equals(expected[i], actual[i]));
        }

        // Example 4
        intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        expected = new int[][]{{1, 10}};
        actual = test.merge(intervals);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(Arrays.equals(expected[i], actual[i]));
        }
    }
}
