package com.embotics.interview;

import com.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IntegerListExaminer {
    /**
     * <p>
     * Given a list of Integers, return a list that contains the elements that
     * form the longest sublist of even integers in the list. If two sublists
     * are of equal length, the first sublist is returned.
     * </p >
     *
     *
     * <p>
     * Examples:
     * <ul>
     * <li>[1 3 3] returns []</li>
     * <li>[2 3 3] returns [2]</li>
     * <li>[2 3 4 6 3] returns [4 6]</li>
     * <li>[2 3 4 6 3 6 8] returns [4 6]</li>
     * <li>[2 4 6 6 8] returns [2 4 6 6 8]</li>
     * </ul>
     * </p >
     *
     * @param list a list of integers
     * @return the longest sublist of even integers in the list; if two sublists
     * are of equal length, the first is returned
     * @throws NullPointerException if the list or any of its elements are null
     */
    public List<Integer> findLongestEvenSublist(List<Integer> list) {
        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        if (list == null) {
            throw new NullPointerException();
        } else if (list.size() == 0) {
            return result.get(0);
        }

        for (Integer item : list) {

            if (item % 2 == 0) {
                result.get(result.size() - 1).add(item);
            } else {
                result.add(new ArrayList<Integer>());
            }
        }

//        // Sort to get the longest list
//        result.sort(Comparator.comparing(ArrayList::size));
//
//        int ind = result.size() - 1;
//        for (int i = result.size() - 1; i >= 1; i--) {
//            if (result.get(i).size() == result.get(i - 1).size()) {
//                ind--;
//            } else {
//                break;
//            }
//        }
//
//        return result.get(ind);

        List<Integer> longest = new ArrayList<Integer>();
        for (List<Integer> l : result) {
            if (longest.size() < l.size()) {
                longest = l;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        IntegerListExaminer examiner = new IntegerListExaminer();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(3);
        list.add(5);

        List<Integer> result = examiner.findLongestEvenSublist(list);
        Utils.printIntergerArray(result);
    }
}