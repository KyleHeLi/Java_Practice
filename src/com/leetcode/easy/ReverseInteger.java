package com.leetcode.easy;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        int remain = x;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        while (remain != 0) {

            int digit = remain % 10;
            remain = remain / 10;

            if ((x >= 0 && (result > (max - 1 - digit) / 10)) ||
                    (x < 0 && (result < (min - digit) / 10))) {
                return 0;
            }

            result = result * 10 + digit;
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();

        // Example 1
        int x = 123;
        System.out.println(test.reverse(x) == 321);

        // Example 2
        x = -123;
        System.out.println(test.reverse(x) == -321);

        // Example 3
        x = 120;
        System.out.println(test.reverse(x) == 21);

        // Example 4
        x = 0;
        System.out.println(test.reverse(x) == 0);

        // Example 5
        x = 2147483647; //1534236469;
        System.out.println(test.reverse(x));

        // Example 6
        x = -2147483648;
        System.out.println(test.reverse(x));


        // Example 7
        x = 1463847412;
        test.reverse(x);
        System.out.println(test.reverse(x));
    }
}
