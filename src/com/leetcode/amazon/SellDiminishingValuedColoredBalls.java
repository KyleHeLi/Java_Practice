package com.leetcode.amazon;

import java.util.*;

// Top Amazon Questions
// tag: Heap (Priority Queue), Math, large integer
public class SellDiminishingValuedColoredBalls {

    public int maxProfit(int[] inventory, int orders) {

        TreeMap<Long, Long> treeMap = new TreeMap<>(); // <The number of balls of specific color, Count>

        for (int number : inventory)
            treeMap.put((long)number, treeMap.getOrDefault((long)number, 0L) + 1);

        long result = 0, mod = (long)Math.pow(10, 9) + 7;

        while (orders > 0)
        {
            Map.Entry<Long, Long> maxEntry = treeMap.pollLastEntry();
            long maxNumber = maxEntry.getKey(), maxCount = maxEntry.getValue(), subMaxNumber = 0;

            if (!treeMap.isEmpty())
                subMaxNumber = treeMap.lastKey();

            long totalCount = (maxNumber - subMaxNumber) * maxCount;

            if (orders >= totalCount)
            {
                long n = maxNumber - subMaxNumber, a1 = maxNumber, an = subMaxNumber + 1;

                result = (result + n * (a1 + an) / 2 * maxCount) % mod; // Note: Sum of arithmetic sequence n * (a1 + an) / 2
                orders -= n * maxCount;

                treeMap.put(subMaxNumber, treeMap.getOrDefault(subMaxNumber, 0L) + maxCount); // Get the orders until maxNumber equals subMaxNumber
            }
            else
            {
                long n = orders / maxCount, a1 = maxNumber, an = a1 - n + 1;

                result = (result + n * (a1 + an) / 2 * maxCount) % mod;
                orders -= n * maxCount;

                result = (result + orders * (an - 1)) % mod;
                break; // orders = 0
            }
        }

        return (int)result;
    }

//    // Worst case: O(n^2)
//    public int maxProfit(int[] inventory, int orders) {
//        if (inventory == null || inventory.length == 0 || orders < 1) {
//            return 0;
//        }
//
//        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
//        for (int i = 0; i < inventory.length; i++) {
//            queue.add(inventory[i]);
//        }
//
//        int max = 0;
//        int i = orders;
//
//        if (queue.size() == 1) {
//            int num = queue.poll();
//            long a = (long) (1 + num) * num / 2;
//            long b = (long) (1 + (num - orders)) * (num - orders) / 2;
//            max = (int) ((a - b) % 1000000007);
//        } else {
//            while (i > 0) {
//                int ball = queue.poll();
//                max = (max + ball) % 1000000007;
//                queue.add(ball - 1);
//                i--;
//            }
//        }
//
//
//        return max;
//    }

    public static void main(String[] args) {
        SellDiminishingValuedColoredBalls test = new SellDiminishingValuedColoredBalls();

        // Example 1
        int[] inventory = new int[]{2, 5};
        int orders = 4;
        int expected = 14;
        int actual = test.maxProfit(inventory, orders);
        System.out.println(expected == actual);

        // Example 2
        inventory = new int[]{3, 5};
        orders = 6;
        expected = 19;
        actual = test.maxProfit(inventory, orders);
        System.out.println(expected == actual);

        // Example 3
        inventory = new int[]{2, 8, 4, 10, 6};
        orders = 20;
        expected = 110;
        actual = test.maxProfit(inventory, orders);
        System.out.println(expected == actual);

        // Example 4
        inventory = new int[]{1000000000};
        orders = 1000000000;
        expected = 21;
        actual = test.maxProfit(inventory, orders);
        System.out.println(expected == actual);
    }
}
