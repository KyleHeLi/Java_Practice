package com.leetcode.medium;

import java.util.*;

import com.leetcode.common.Utils;

public class GenerateParenteses {

    // better solution
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, 0, new StringBuilder(), result);
        return result;
    }

    private void helper(int n, int openBracketsNotPaired, StringBuilder soFar, List<String> result)
    {
        if (n == 0 && openBracketsNotPaired == 0)
        {
            result.add(soFar.toString());
        }
        else
        {
            // if n is not down to 0 yet, we can still chose to use "("
            if (n > 0)
            {
                //choose
                soFar.append("(");
                //explore
                // an open bracket starts a pair, so n become one less, and number of open brackets increase by one
                helper(n-1, openBracketsNotPaired+1, soFar, result);
                //unchoose
                soFar.setLength(soFar.length()-1);
            }

            // if there is still open brackets not paired, we can chose to use "("
            if (openBracketsNotPaired > 0)
            {
                //choose
                soFar.append(")");
                //explore
                //a close bracket only close out an open bracket, it does not impact how many pairs still need to be created, so n does not change here
                helper(n, openBracketsNotPaired-1, soFar, result);
                //unchoose
                soFar.setLength(soFar.length()-1);
            }
        }
    }

//    public List<String> generateParenthesis(int n) {
//        if (n < 1) return new LinkedList<String>();
//
//        Map<String, Boolean> map = new HashMap<String, Boolean>();
//
//        List<String> result = new LinkedList<String>();
//        result.add("()");
//
//        backtrack(n, map, result);
//
//        return result;
//    }
//
//    private void backtrack(int n, Map<String, Boolean> map, List<String> result) {
//
//        if (result == null || result.size() == 0) return;
//
//        if (result.get(0).length() == 2 * n) {
//            return;
//        }
//
//        String item = result.remove(0);
//        map.put(item, false);
//
//        for (int i = 0; i < item.length(); i++) {
//            String toAdd = item.substring(0, i+1) + "()" + item.substring(i+1);
//
//            if (!map.containsKey(toAdd) || !map.get(toAdd)) {
//                result.add(toAdd);
//                map.put(toAdd, true);
//            }
//        }
//
//        backtrack(n, map, result);
//    }

    public static void main(String[] args) {
        GenerateParenteses test = new GenerateParenteses();

        // Example 1
        int n = 3;
        Utils.printStringArray(test.generateParenthesis(n));

        // Example 2
        n = 2;
        Utils.printStringArray(test.generateParenthesis(n));

        n = 1;
        Utils.printStringArray(test.generateParenthesis(n));
    }
}
