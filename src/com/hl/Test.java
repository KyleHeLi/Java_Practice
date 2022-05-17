package com.hl;

public class Test {
    public static void main(String[] args) {
        int m = 100;
        int j = 25;
        int s = 39;
        if (m < j + 2* s) s = 2*m;
        else j = 2*s;
        System.out.println("m = " + m + " j = "+ j + " s = " + s);

    }
}
