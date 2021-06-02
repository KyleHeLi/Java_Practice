package com.nowcoder.huawei;

import java.util.Scanner;

public class HJ2 {
    public int count(String str, String c) {
        int sum = 0;
        for (int i = 0, len = str.length(); i < len; i++) {
            String tmp = String.valueOf(str.charAt(i));
            if (String.valueOf(str.charAt(i)).toLowerCase().equals(c.toLowerCase())) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        HJ2 test = new HJ2();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String c = sc.nextLine();

        int result = test.count(str, c);
        System.out.println(result);
    }
}
