package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    /**
         Symbol       Value
         I             1
         V             5
         X             10
         L             50
         C             100
         D             500
         M             1000
     */
    public static Map<String, Integer> symbols = new HashMap<String, Integer>(){{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};

    public int romanToInt(String s) {
        int result = 0;
        int i = 0;
        int length = s.length();
        while (i < length) {
            if (i + 1 < length && symbols.containsKey(s.substring(i, i + 2))) {
                result += symbols.get(s.substring(i, i + 2));
                i += 2;
            } else {
                result += symbols.get(s.substring(i, i + 1));
                i += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RomanToInteger test = new RomanToInteger();

        // Example 1
        String s = "III";
        int result = test.romanToInt(s);
        System.out.println(result == 3);

        // Example 2
        s = "IV";
        result = test.romanToInt(s);
        System.out.println(result == 4);

        // Example 3
        s = "IX";
        result = test.romanToInt(s);
        System.out.println(result == 9);

        // Example 4
        s = "LVIII";
        result = test.romanToInt(s);
        System.out.println(result == 58);

        // Example 5
        s = "MCMXCIV";
        result = test.romanToInt(s);
        System.out.println(result == 1994);

        // Example 6
        s = "DCXXI";
        result = test.romanToInt(s);
        System.out.println(result == 621);
    }
}
