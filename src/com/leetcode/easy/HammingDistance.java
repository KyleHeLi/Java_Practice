package com.leetcode.easy;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int sum = 0;
        int bitmask = 0x0001;
        for (int i = 0; i < 31; i++) {
            if ((x & bitmask) != (y & bitmask)) {
                sum++;
            }
            x >>= 1;
            y >>= 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        HammingDistance test = new HammingDistance();

        // Example
        int x = 1, y = 4;
        System.out.println(test.hammingDistance(x, y) == 2);
    }
}
