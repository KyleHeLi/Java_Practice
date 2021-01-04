package com.leetcode.medium;

import java.util.ArrayList;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();

        if (numRows <= 0) {
            return "";
        } else if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        ArrayList<ArrayList<Character>> zigZag = new ArrayList<ArrayList<Character>>();
        for (int i = 0, length = numRows; i < length; i++) {
            zigZag.add(new ArrayList<Character>());
        }
        int row = 0;
        int step = 1;
        for (char letter : s.toCharArray()) {
            zigZag.get(row).add(letter);
            if (row == 0) {
                step = 1;
            } else if (row == numRows - 1) {
                step = -1;
            }
            row += step;
        }

        for (ArrayList<Character> x : zigZag) {
            StringBuilder builder = new StringBuilder();
            for (char c : x) {
                builder.append(c);
            }
            sb.append(builder);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion test = new ZigZagConversion();

        // Example 1
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(test.convert(s, numRows).equals("PAHNAPLSIIGYIR"));

        // Example 2
        s = "PAYPALISHIRING";
        numRows = 4;
        System.out.println(test.convert(s, numRows).equals("PINALSIGYAHRPI"));

        // Example 3
        s = "A";
        numRows = 1;
        System.out.println(test.convert(s, numRows).equals("A"));
    }
}
