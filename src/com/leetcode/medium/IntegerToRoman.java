package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
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
    public String intToRoman(int num) {
        int m = num / 1000;
        int c = num % 1000 / 100;
        int x = num % 100 / 10;
        int i = num % 10;

        StringBuilder s = new StringBuilder();

        s.append(helper(m, 'M'));
        s.append(helper(c, 'C'));
        s.append(helper(x, 'X'));
        String a = helper(i, 'I');
        s.append(a);

        return s.toString();
    }

    private String helper(int digit, char c) {
        StringBuilder sb = new StringBuilder();

        String x = "", y = "", z = "";
        switch (c) {
            case 'M':   // thousand
                x = "M";
                break;
            case 'C':   // hundred
                x = "C";
                y = "D";
                z = "M";
                break;
            case 'X':   // ten
                x = "X";
                y = "L";
                z = "C";
                break;
            case 'I':
                x = "I";
                y = "V";
                z = "X";
                break;
            default:
                break;
        }

        if (digit < 4) {
            for (int j = 0; j < digit; j++) {
                sb.append(x);
            }
        } else if (digit == 4) {
            sb.append(x + y);
        } else if (digit == 5) {
            sb.append(y);
        } else if (digit == 9) {
            sb.append(x + z);
        } else {
            sb.append(y);
            for (int j = 0; j < digit % 5; j++) {
                sb.append(x);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman test = new IntegerToRoman();

        // Example 1
        int num = 3;
        String result = test.intToRoman(num);
        System.out.println(result.equals("III"));

        // Example 2
        num = 4;
        result = test.intToRoman(num);
        System.out.println(result.equals("IV"));

        // Example 3
        num = 9;
        result = test.intToRoman(num);
        System.out.println(result.equals("IX"));

        // Example 4
        num = 58;
        result = test.intToRoman(num);
        System.out.println(result.equals("LVIII"));

        // Example 5
        num = 1994;
        result = test.intToRoman(num);
        System.out.println(result.equals("MCMXCIV"));
    }
}
