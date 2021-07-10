package com.leetcode.amazon;

import java.util.HashMap;
import java.util.Map;

// Top Amazon Questions
// tag: string
public class IntegerToEnglishWords {
    String one[] = {"", "One ", "Two ", "Three ", "Four ",
            "Five ", "Six ", "Seven ", "Eight ",
            "Nine ", "Ten ", "Eleven ", "Twelve ",
            "Thirteen ", "Fourteen ", "Fifteen ",
            "Sixteen ", "Seventeen ", "Eighteen ",
            "Nineteen "};

    String ten[] = {"", "", "Twenty ", "Thirty ", "Forty ",
            "Fifty ", "Sixty ", "Seventy ", "Eighty ",
            "Ninety "};

    String unitsInString[] = {"Billion ", "Million ", "Thousand ", "Hundred "};
    int units[] = {1000000000, 1000000, 1000, 100};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        return numberToWordsUtil(num).trim();
    }

    private String numberToWordsUtil(int num) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < units.length; i++) {
            int value = handleDigitsInWords(num, units[i], unitsInString[i], result);
            num = digitHandler(num, value, units[i]);
        }

        if (num < 20)
            result.append(one[num]);
        else
            result.append(ten[num / 10] + one[num % 10]);
        return result.toString();
    }

    private int handleDigitsInWords(int num, int unit, String unitInWords, StringBuilder result) {
        int answer = num / unit;
        if (answer > 0)
            result.append(numberToWordsUtil(answer) + unitInWords);
        return answer;
    }

    private int digitHandler(int num, int digit, int unit) {
        return (num - digit * unit) >= 0 ? num - digit * unit : num;
    }

    public static void main(String[] args) {
        IntegerToEnglishWords test = new IntegerToEnglishWords();

        // Example 1
        int num = 123;
        String expected = "One Hundred Twenty Three";
        String actual = test.numberToWords(num);
        System.out.println(expected.equals(actual));

        // Example 2
        num = 12345;
        expected = "Twelve Thousand Three Hundred Forty Five";
        actual = test.numberToWords(num);
        System.out.println(expected.equals(actual));

        // Example 3
        num = 1234567;
        expected = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";
        actual = test.numberToWords(num);
        System.out.println(expected.equals(actual));

        // Example 4
        num = 1234567891;
        expected = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One";
        actual = test.numberToWords(num);
        System.out.println(expected.equals(actual));
    }
}

// Solution
//class Solution {
//    public String one(int num) {
//        switch(num) {
//            case 1: return "One";
//            case 2: return "Two";
//            case 3: return "Three";
//            case 4: return "Four";
//            case 5: return "Five";
//            case 6: return "Six";
//            case 7: return "Seven";
//            case 8: return "Eight";
//            case 9: return "Nine";
//        }
//        return "";
//    }
//
//    public String twoLessThan20(int num) {
//        switch(num) {
//            case 10: return "Ten";
//            case 11: return "Eleven";
//            case 12: return "Twelve";
//            case 13: return "Thirteen";
//            case 14: return "Fourteen";
//            case 15: return "Fifteen";
//            case 16: return "Sixteen";
//            case 17: return "Seventeen";
//            case 18: return "Eighteen";
//            case 19: return "Nineteen";
//        }
//        return "";
//    }
//
//    public String ten(int num) {
//        switch(num) {
//            case 2: return "Twenty";
//            case 3: return "Thirty";
//            case 4: return "Forty";
//            case 5: return "Fifty";
//            case 6: return "Sixty";
//            case 7: return "Seventy";
//            case 8: return "Eighty";
//            case 9: return "Ninety";
//        }
//        return "";
//    }
//
//    public String two(int num) {
//        if (num == 0)
//            return "";
//        else if (num < 10)
//            return one(num);
//        else if (num < 20)
//            return twoLessThan20(num);
//        else {
//            int tenner = num / 10;
//            int rest = num - tenner * 10;
//            if (rest != 0)
//                return ten(tenner) + " " + one(rest);
//            else
//                return ten(tenner);
//        }
//    }
//
//    public String three(int num) {
//        int hundred = num / 100;
//        int rest = num - hundred * 100;
//        String res = "";
//        if (hundred*rest != 0)
//            res = one(hundred) + " Hundred " + two(rest);
//        else if ((hundred == 0) && (rest != 0))
//            res = two(rest);
//        else if ((hundred != 0) && (rest == 0))
//            res = one(hundred) + " Hundred";
//        return res;
//    }
//
//    public String numberToWords(int num) {
//        if (num == 0)
//            return "Zero";
//
//        int billion = num / 1000000000;
//        int million = (num - billion * 1000000000) / 1000000;
//        int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
//        int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;
//
//        String result = "";
//        if (billion != 0)
//            result = three(billion) + " Billion";
//        if (million != 0) {
//            if (! result.isEmpty())
//                result += " ";
//            result += three(million) + " Million";
//        }
//        if (thousand != 0) {
//            if (! result.isEmpty())
//                result += " ";
//            result += three(thousand) + " Thousand";
//        }
//        if (rest != 0) {
//            if (! result.isEmpty())
//                result += " ";
//            result += three(rest);
//        }
//        return result;
//    }
//}