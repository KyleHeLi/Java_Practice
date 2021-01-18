package com.leetcode.medium;

import java.util.*;

public class RearrangeWordsInASentence {

    // better solution
    public String arrangeWords(String text) {
        if (text == null || text.length() == 0) {
            return text;
        }

        String[] arr = text.split(" ");
        arr[0] = arr[0].substring(0,1).toLowerCase() + arr[0].substring(1);
        Arrays.sort(arr, (a,b)->(a.length()-b.length()));
        arr[0] = arr[0].substring(0,1).toUpperCase() + arr[0].substring(1);

        StringBuilder result = new StringBuilder(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            result.append(" " + arr[i]);
        }

        return result.toString();
    }

//    public String arrangeWords(String text) {
//        String[] strArray= text.split(" ");
//
//        Map<Integer, String> map = new TreeMap<Integer, String>();
//
//        for (String str : strArray) {
//            int l = str.length();
//
//            if (!map.containsKey(l)) {
//                map.put(l, "");
//            }
//
//            map.put(l, map.get(l) + " " + str.toLowerCase());
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            sb.append(entry.getValue());
//        }
//
//        sb.replace(0, 1, "");
//
//        if (sb.length() > 0) {
//            sb.replace(0, 1, sb.substring(0, 1).toUpperCase());
//        }
//
//        return sb.toString();
//    }

    public static void main(String[] args) {
        RearrangeWordsInASentence test = new RearrangeWordsInASentence();

        // Example 1
        String text = "Leetcode is cool";
        String result = test.arrangeWords(text);
        System.out.println(result.equals("Is cool leetcode"));

        // Example 2
        text = "Keep calm and code on";
        result = test.arrangeWords(text);
        System.out.println(result.equals("On and keep calm code"));

        // Example 3
        text = "To be or not to be";
        result = test.arrangeWords(text);
        System.out.println(result.equals("To be or to be not"));

        // Example 4
        text = "";
        result = test.arrangeWords(text);
        System.out.println(result.equals(""));

        // Example 5
        text = "test";
        result = test.arrangeWords(text);
        System.out.println(result.equals("Test"));
    }
}
