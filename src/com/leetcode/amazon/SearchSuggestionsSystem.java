package com.leetcode.amazon;

import java.util.*;

// Top Amazon Questions
// tag: Binary Search
public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (products == null || products.length == 0 || searchWord == null || searchWord.length() == 0) {
            return null;
        }

        TreeMap<String, Object> bst = new TreeMap<String, Object>();
        for (int i = 0; i < products.length; i++) {
            bst.put(products[i], null);
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String p = searchWord.substring(0, i);
            Map<String, Object> prefix = bst.subMap(p, p + Character.MAX_VALUE);
            List<String> tmp = new ArrayList<>(prefix.keySet());
            if (tmp.size() > 3) {
                result.add(tmp.subList(0, 3));
            } else {
                result.add(tmp);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem test = new SearchSuggestionsSystem();

        // Example 1
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> result = test.suggestedProducts(products, searchWord);

        // Example 2
        products = new String[]{"havana"};
        searchWord = "havana";
        result = test.suggestedProducts(products, searchWord);

        // Example 3
        products = new String[]{"bags", "baggage", "banner", "box", "cloths"};
        searchWord = "bags";
        result = test.suggestedProducts(products, searchWord);
    }
}
