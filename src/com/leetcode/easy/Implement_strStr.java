package com.leetcode.easy;

public class Implement_strStr {
    // Better solution
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (matches(i, haystack, needle)) {
                return i;
            }
        }

        return -1;
    }

    private boolean matches(int start, String haystack, String needle) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(start + i) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }

//    public int strStr(String haystack, String needle) {
//        if (needle == null || needle.length() == 0) {
//            return 0;
//        }
//
//        int index = -1;
//
//        if (haystack != null) {
//            for (int i = 0; i < haystack.length(); i++) {
//                int j = 0;
//                while (i + j < haystack.length() && j < needle.length()) {
//                    if (haystack.charAt(i + j) == needle.charAt(j)) {
//                        j++;
//                    } else {
//                        break;
//                    }
//                }
//
//                if (j == needle.length()) {
//                    index = i;
//                    break;
//                }
//            }
//        }
//
//        return index;
//    }

    public static void main(String[] args) {
        Implement_strStr test = new Implement_strStr();

        // Example 1
        String haystack = "hello";
        String needle = "ll";
        int result = test.strStr(haystack, needle);
        System.out.println(result == 2);

        // Example 2
        haystack = "aaaaa";
        needle = "bba";
        result = test.strStr(haystack, needle);
        System.out.println(result == -1);

        // Example 3
        haystack = "";
        needle = "";
        result = test.strStr(haystack, needle);
        System.out.println(result == 0);

        // Example 4
        haystack = "aaa";
        needle = "aaaa";
        result = test.strStr(haystack, needle);
        System.out.println(result == -1);

        // Example 5
        haystack = "mississippi";
        needle = "issipi";
        result = test.strStr(haystack, needle);
        System.out.println(result == -1);
    }
}
