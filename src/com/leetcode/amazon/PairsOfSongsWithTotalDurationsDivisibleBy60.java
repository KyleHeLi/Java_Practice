package com.leetcode.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Top Amazon Questions
// tag: array, hash table
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    // better solution
    // t -> O(n), s -> O(1)
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t : time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }

//    // t -> O(n^2), s -> O(n)
//    public int numPairsDivisibleBy60(int[] time) {
//        if (time == null || time.length < 2) {
//            return 0;
//        }
//
//        int result = 0;
//
//        for (int i = 0; i < time.length; i++) {
//            for (int j = i + 1; j < time.length; j++) {
//                if ((time[i] + time[j]) % 60 == 0) {
//                    result++;
//                }
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        PairsOfSongsWithTotalDurationsDivisibleBy60 test = new PairsOfSongsWithTotalDurationsDivisibleBy60();

        // Example 1
        int[] time = new int[]{30, 20, 150, 100, 40};
        int expected = 3;
        int actual = test.numPairsDivisibleBy60(time);
        System.out.println(expected == actual);


        // Example 2
        time = new int[]{60, 60, 60};
        expected = 3;
        actual = test.numPairsDivisibleBy60(time);
        System.out.println(expected == actual);
    }
}
