package com.leetcode.easy;

public class LongestCommonPrefix {
    // better solution
    public String longestCommonPrefix(String[] strs) {
        int count = 0;
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        while (count < strs[0].length()) {
            for (int j = 1; j < strs.length; j++) {
                if (count >= strs[j].length() || strs[j].charAt(count) != strs[0].charAt(count)) {
                    return strs[0].substring(0, count);
                }
            }
            count++;
        }

        return strs[0];
    }

//    public String longestCommonPrefix(String[] strs) {
//
//        int minLen = Integer.MAX_VALUE;
//        for (int i = 0, length = strs.length; i < length; i++) {
//            if (strs[i].length() < minLen) {
//                minLen = strs[i].length();
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        if (minLen != Integer.MAX_VALUE) {
//            int i = 0;
//            while (i < minLen) {
//                boolean add = true;
//
//                for (int j = 0, length = strs.length; j < length - 1; j++) {
//                    if (strs[j].charAt(i) != strs[j+1].charAt(i)) {
//                        i = minLen;
//                        add = false;
//                        break;
//                    }
//                }
//
//                if (add && i < minLen) {
//                    sb.append(strs[0].charAt(i));
//                }
//
//                i++;
//            }
//        }
//
//        return sb.toString();
//    }

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();

        // Example 1
        String[] strs = new String[]{"flower", "flow", "flight"};
        String result = test.longestCommonPrefix(strs);
        System.out.println(result.equals("fl"));

        // Example 2
        strs = new String[]{"dog", "racecar", "car"};
        result = test.longestCommonPrefix(strs);
        System.out.println(result.equals(""));
    }
}
