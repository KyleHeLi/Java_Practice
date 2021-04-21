package com.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationInString {
    // better solution
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
        }


        for (int i = 0; i < s2.length(); i++) {

            char c = s2.charAt(i);
            arr2[c - 'a']++;

            if (i >= s1.length()) {
                char ch = s2.charAt(i - s1.length());
                arr2[ch - 'a']--;
            }

            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }

//    public boolean checkInclusion(String s1, String s2) {
//        int len1 = s1.length();
//        int len2 = s2.length();
//
//        boolean result = false;
//
//        char[] s1Array = s1.toCharArray();
//        Arrays.sort(s1Array);
//        String str = new String(s1Array);
//
//        for (int i = 0; i + len1 <= len2; i++) {
//            String s = s2.substring(i, i + len1);
//            char[] s2SubArray = s.toCharArray();
//            Arrays.sort(s2SubArray);
//            String str2 = new String(s2SubArray);
//
//            if (str.equals(str2)) {
//                result = true;
//                break;
//            }
//        }
//
//
//        return result;
//    }

    public static void main(String[] args) {
        PermutationInString test = new PermutationInString();

        // Example 1
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = test.checkInclusion(s1, s2);
        System.out.println(result == true);

        // Example 2
        s1 = "ab";
        s2 = "eidboaoo";
        result = test.checkInclusion(s1, s2);
        System.out.println(result == false);

        // Example 3
        s1 = "adc";
        s2 = "dcda";
        result = test.checkInclusion(s1, s2);
        System.out.println(result == true);
    }
}
