package com.leetcode.amazon;

import java.util.*;

public class RandomizedSet {
    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    List<Integer> arr;
    Random random;
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        arr = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        arr.add(val);
        map.put(val, arr.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        if (index != arr.size() - 1) {
            int tailVal = arr.get(arr.size() - 1);
            int currentVal = arr.get(index);
            arr.set(index, tailVal);
            arr.remove(arr.size() - 1);
            map.remove(currentVal);
            map.put(tailVal, index);
        } else {
            int tailVal = arr.remove(arr.size() - 1);
            map.remove(tailVal);
        }

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (arr.size() == 0) {
            return -1;
        }

        int randomInd = random.nextInt(arr.size());

        return arr.get(randomInd);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean t = randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        t = randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
        t = randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        int r = randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        t = randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        t = randomizedSet.insert(2); // 2 was already in the set, so return false.
        r = randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}
