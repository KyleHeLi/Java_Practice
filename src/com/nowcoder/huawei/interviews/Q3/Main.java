package com.nowcoder.huawei.interviews.Q3;

import java.util.Scanner;

public class Main {
    public int count(String str, String c) {
        int sum = 0;
        for (int i = 0, len = str.length(); i < len; i++) {
            String tmp = String.valueOf(str.charAt(i));
            if (tmp.toUpperCase().equals(c) || tmp.toLowerCase().equals(c)) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Main test = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String c = sc.nextLine();

        int result = test.count(str, c);
        System.out.println(result);
    }
}
