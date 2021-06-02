package com.nowcoder.huawei.interviews.Q1;

import java.util.*;

public class Main {
    public int add(String str) {
        String[] input = str.split(" ");
        return Integer.parseInt(input[0]) + Integer.parseInt(input[1]);
    }

    public static void main(String[] args) {
        Main test = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int result = test.add(str);
        System.out.println(result);
    }
}
