package com.hackerrank.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SalesByMatch {


    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        int result = 0;
        Map<Integer, Integer> socks = new HashMap<Integer, Integer>();
        for (int sock : ar) {
            if (socks.containsKey(sock)) {
                socks.put(sock, socks.get(sock) + 1);
            } else {
                socks.put(sock, 1);
            }
        }

        for (int sock : socks.keySet()) {
            result += socks.get(sock) / 2;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
