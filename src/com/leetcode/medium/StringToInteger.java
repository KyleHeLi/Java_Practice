package com.leetcode.medium;

public class StringToInteger {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }

        boolean sign = false;
        boolean start = true;
        int result = 0;
        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ' && start) {
                continue;
            } else if (c == '-' && start) {
                sign = true;
                start = false;
            } else if (c == '+' && start) {
                start = false;
            } else if (c >= '0' && c <= '9') {
                int digit = c - '0';
                if (sign) {
                    if (result < (Integer.MIN_VALUE + digit) / 10) {
                        result = Integer.MIN_VALUE;
                        break;
                    } else {
                        result = result * 10 - digit;
                    }
                } else {
                    if (result > (Integer.MAX_VALUE - digit) / 10) {
                        result = Integer.MAX_VALUE;
                        break;
                    } else {
                        result = result * 10 + digit;
                    }
                }
                start = false;
            } else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        StringToInteger test = new StringToInteger();

        // Example 1
        String str = "42";
        int result = test.myAtoi(str);
        System.out.println(result == 42);

        // Example 2
        str = "   -42";
        result = test.myAtoi(str);
        System.out.println(result == -42);

        // Example 3
        str = "4193 with words";
        result = test.myAtoi(str);
        System.out.println(result == 4193);

        // Example 4
        str = "words and 987";
        result = test.myAtoi(str);
        System.out.println(result == 0);

        // Example 5
        str = "-91283472332";
        result = test.myAtoi(str);
        System.out.println(result == Integer.MIN_VALUE);

        // Example 6
        str = "   +0 123";
        result = test.myAtoi(str);
        System.out.println(result == 0);

    }
}
