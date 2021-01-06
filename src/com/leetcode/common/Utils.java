package com.leetcode.common;

import java.util.List;

public class Utils {
    public static void printStringArray(List<String> array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (array != null) {
            for (int i = 0, length = array.size(); i < length; i++) {
                sb.append(array.get(i));
                if (i + 1 < length) {
                    sb.append(", ");
                }
            }
        }

        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void printIntergerArray(List<Integer> array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (array != null) {
            for (int i = 0, length = array.size(); i < length; i++) {
                sb.append(array.get(i).toString());
                if (i + 1 < length) {
                    sb.append(", ");
                }
            }
        }

        sb.append("]");
        System.out.println(sb.toString());
    }
}
