package com.nowcoder.huawei.interviews.Q2;

import java.util.Scanner;

public class Main {
    public int swapCount(int[] array) {
        int[] a = new int[array.length];
        int[] b = new int[array.length];

        System.arraycopy(array, 0, a, 0, array.length);
        System.arraycopy(array, 0, b, 0, array.length);

        int sum = 0;
        for (int i = 0, len = a.length; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }

            int tmp = a[i];
            a[i] = a[min];
            a[min] = a[i];

            if (min != i) {
                sum++;
            }

            boolean sorted = true;
            for (int k = 0; k < a.length-1; k++) {
                if (a[k] > a[k+1]) {
                    sorted = false;
                }
            }

            if (sorted) {
                break;
            }
        }

        int sum2 = 0;
        for (int i = 0, len = b.length; i < len; i++) {
            int max = i;
            for (int j = i + 1; j < len; j++) {
                if (b[max] > b[j]) {
                    max = j;
                }
            }

            int tmp = b[i];
            b[i] = b[max];
            b[max] = b[i];

            if (max != i) {
                sum2++;
            }

            boolean sorted = true;
            for (int k = 0; k < b.length-1; k++) {
                if (b[k] < b[k+1]) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                break;
            }
        }

        return Math.min(sum, sum2);
    }

    public static void main(String[] args) {
        Main test = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] array = str.split(",");
        int[] intArray = new int[array.length];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }

        int result = test.swapCount(intArray);
        System.out.println(result);
    }
}
