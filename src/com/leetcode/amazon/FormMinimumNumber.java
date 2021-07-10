package com.leetcode.amazon;

public class FormMinimumNumber {
    // https://www.lintcode.com/problem/1890/

    // Description
    // Given a pattern str containing only I and D.
    // I for increasing and D for decreasing.
    // Please design an algorithm to return the string that conforms to the pattern and has the smallest dictionary order.
    // Digits from 1 to 9 and digits can’t repeat.

    /**
     * @param str: the pattern
     * @return: the minimum number
     */
    public String formMinimumNumber(String str) {
        // Write your code here.
        return "";
    }

    public static void main(String[] args) {
        FormMinimumNumber test = new FormMinimumNumber();
        String str = "D";
        String result = test.formMinimumNumber(str);
        System.out.println(result.equals("21"));

        str = "II";
        result = test.formMinimumNumber(str);
        System.out.println(result.equals("123"));

        str = "DIDI";
        result = test.formMinimumNumber(str);
        System.out.println(result.equals("21435"));

        str = "DDIDDIID";
        result = test.formMinimumNumber(str);
        System.out.println(result.equals("321654798"));
    }
}
