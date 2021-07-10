package com.leetcode.amazon;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
    //map to store list of sites visited -> to its string representation which we will refer as sequence
    Map<List<String>, String> siteToSeqMap;

    private class Visit {
        int timestamp;
        String website;

        private Visit(int timestamp, String website) {
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        HashMap<String, List<Visit>> visitMap = new HashMap();
        siteToSeqMap = new HashMap<>();

        // Sort every entry in map and process right away in visitMap map
        for (int i = 0; i < username.length; i++) {
            if (!visitMap.containsKey(username[i])) {
                visitMap.put(username[i], new ArrayList<Visit>());
            }
            visitMap.get(username[i]).add(new Visit(timestamp[i], website[i]));
            visitMap.get(username[i]).sort((a, b) -> a.timestamp - b.timestamp);
        }

        // Make unique 3-sequence
        Map<String, Integer> freqMap = new HashMap<>();
        for (String user : visitMap.keySet()) {
            List<Visit> visitedSites = visitMap.get(user);
            if (visitedSites.size() > 2) {
                Set<String> threeSequence = get3Sequence(visitedSites);
                threeSequence.forEach(str -> {
                    freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
                });
            }
        }

        int max = 0;
        List<String> result = new ArrayList<>();
        //siteToSeqMap contains list of sites -> seq in string
        //we get list with max freq, if freq is same we return smaller LIST, not smaller string sequence
        for (List<String> key : siteToSeqMap.keySet()) {
            String seq = siteToSeqMap.get(key);
            if (freqMap.get(seq) > max) {
                max = freqMap.get(seq);
                result = key;
            } else if (freqMap.get(seq) == max) {
                result = result == null ? key : getSmallest(result, key);
            }
        }

        return result;
    }

    private Set<String> get3Sequence(List<Visit> sites) {
        Set<String> result = new HashSet<>();
        if (sites.size() == 3) {
            String str = sites.get(0).website + sites.get(1).website + sites.get(2).website;
            result.add(str);
            List<String> strList = new ArrayList<>();
            strList.add(sites.get(0).website);
            strList.add(sites.get(1).website);
            strList.add(sites.get(2).website);
            siteToSeqMap.put(strList, str);
            return result;
        }

        for (int i = 0; i < sites.size() - 2; i++) {
            for (int j = i + 1; j < sites.size() - 1; j++) {
                for (int k = j + 1; k < sites.size(); k++) {
                    String str = sites.get(i).website + sites.get(j).website + sites.get(k).website;
                    if (!result.contains(str)) {
                        List<String> strList = new ArrayList<>();
                        strList.add(sites.get(i).website);
                        strList.add(sites.get(j).website);
                        strList.add(sites.get(k).website);
                        result.add(str);
                        siteToSeqMap.put(strList, str);
                    }
                }
            }
        }

        return result;
    }

    private List<String> getSmallest(List<String> a, List<String> b) {
        for (int i = 0; i < 3; i++) {
            if (a.get(i).equals(b.get(i)))
                continue;
            else
                return a.get(i).compareTo(b.get(i)) < 0 ? a : b;
        }
        return null;
    }

    public static void main(String[] args) {
        AnalyzeUserWebsiteVisitPattern test = new AnalyzeUserWebsiteVisitPattern();

        // Example 1
        String[] username = new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        int[] timestamp = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] website = new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
        List<String> expected = Arrays.asList(new String[]{"home", "about", "career"});
        List<String> actual = test.mostVisitedPattern(username, timestamp, website);
        for (int i = 0; i < actual.size(); i++) {
            System.out.println(expected.get(i).equals(actual.get(i)));
        }

        // Example 2
        username = new String[]{"u1", "u1", "u1", "u2", "u2", "u2"};
        timestamp = new int[]{1, 2, 3, 4, 5, 6};
        website = new String[]{"a", "b", "a", "a", "b", "c"};
        expected = Arrays.asList(new String[]{"a", "b", "a"});
        actual = test.mostVisitedPattern(username, timestamp, website);
        for (int i = 0; i < actual.size(); i++) {
            System.out.println(expected.get(i).equals(actual.get(i)));
        }
    }
}
