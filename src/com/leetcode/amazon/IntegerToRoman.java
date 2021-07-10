package com.leetcode.amazon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Top Amazon Questions
public class IntegerToRoman {
    Map<Integer, String> ROMAN_MAP = new HashMap<Integer, String>() {
        {
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(6, "VI");
            put(9, "IX");
            put(10, "X");
            put(11, "XI");
            put(40, "XL");
            put(50, "L");
            put(60, "LX");
            put(90, "XC");
            put(100, "C");
            put(110, "CX");
            put(400, "CD");
            put(500, "D");
            put(600, "DC");
            put(900, "CM");
            put(1000, "M");
            put(1100, "MC");
        }
    };

    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();

        int divide = 1000;
        while (divide > 0) {
            int d = num % (divide * 10) / divide;
            if (d > 0) {
                result.append(transform(d, divide));
            }
            divide /= 10;
        }

        return result.toString();
    }

    private String transform(int digit, int num) {
        if (ROMAN_MAP.containsKey(digit * num)) {
            return ROMAN_MAP.get(digit * num);
        }

        StringBuffer s = new StringBuffer();
        if (digit / 5 > 0) {
            s.append(ROMAN_MAP.get(5 * num));
        }

        for (int i = 0; i < digit % 5; i++) {
            s.append(ROMAN_MAP.get(num));
        }

        return s.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman test = new IntegerToRoman();
        int num = 3;
        String expected = "III";
        String actual = test.intToRoman(num);
        System.out.println(expected.equals(actual));

        num = 4;
        expected = "IV";
        actual = test.intToRoman(num);
        System.out.println(expected.equals(actual));

        num = 9;
        expected = "IX";
        actual = test.intToRoman(num);
        System.out.println(expected.equals(actual));

        num = 58;
        expected = "LVIII";
        actual = test.intToRoman(num);
        System.out.println(expected.equals(actual));

        num = 1994;
        expected = "MCMXCIV";
        actual = test.intToRoman(num);
        System.out.println(expected.equals(actual));
    }
}
