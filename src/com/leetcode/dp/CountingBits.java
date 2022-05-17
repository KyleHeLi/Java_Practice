package com.leetcode.dp;

public class CountingBits {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int a = i % 2;
            int b = i / 2;
            res[i] = res[b] + a;
        }

        return res;
    }

    public static void main(String[] args) {
        CountingBits test = new CountingBits();
        int n = 2;
        int[] res = test.countBits(n);
        System.out.println(res);

        n = 5;
        res = test.countBits(n);
        System.out.println(res);
    }
}
