package com.nowcoder.huawei;

import java.util.Scanner;

public class HJ1 {
    public int count(String str) {
        int sum = 0;
        for (int i = 0, len = str.length(); i < len; i++) {
            if (str.charAt(i) != ' ') {
                sum++;
            } else {
                sum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        HJ1 test = new HJ1();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int result = test.count(sc.nextLine());
            System.out.println(result);
        }

//        int result = test.count("hello nowcoder");
//        System.out.println(result);
//
//        result = test.count("XSUWHQ");
//        System.out.println(result);
    }
}
