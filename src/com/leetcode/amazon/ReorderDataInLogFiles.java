package com.leetcode.amazon;

import java.util.ArrayList;

public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letterLogs = new ArrayList<String>();
        ArrayList<String> digitLogs = new ArrayList<String>();
        String[] allLogs = new String[logs.length];

        for(String log : logs) {
            int spaceIndex = log.indexOf(" ");
            String identifier = log.substring(0, spaceIndex);
            String content = log.substring(spaceIndex + 1);
            char c = content.toCharArray()[0];
            if (Character.isDigit(c)) {
                digitLogs.add(log);
            } else {
                int indexToInsert = 0;
                for (int i = 0, length = letterLogs.size(); i < letterLogs.size(); i++) {
                    String letterLog = letterLogs.get(i);
                    int spaceIndex2 = letterLog.indexOf(" ");
                    String identifier2 = letterLog.substring(0, spaceIndex2);
                    String content2 = letterLog.substring(spaceIndex2 + 1);
                    if (content.compareTo(content2) > 0) {
                        indexToInsert++;
                    } else if (content.compareTo(content2) == 0) {
                        if (identifier.compareTo(identifier2) > 0) {
                            indexToInsert++;
                        }
                    } else {
                        break;
                    }
                }
                letterLogs.add(indexToInsert, log);
            }
        }


        for (int i = 0, length = letterLogs.size(); i < length; i++) {
            allLogs[i] = letterLogs.get(i);
        }

        for (int i = 0, offset = letterLogs.size(), length = digitLogs.size(); i < length; i++) {
            allLogs[offset + i] = digitLogs.get(i);
        }

        return allLogs;
    }

    public static String printStringArray(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");

        if (strings != null && strings.length > 0) {
            for (String string : strings) {
                stringBuilder.append(string);
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};

        ReorderDataInLogFiles result = new ReorderDataInLogFiles();

        System.out.println(String.format("Output: %s", printStringArray(result.reorderLogFiles(logs))));

        logs = new String[]{"d 02", "2 5 3", "k r y", "6 srs", "x fp"};

        result = new ReorderDataInLogFiles();

        System.out.println(String.format("Output: %s", printStringArray(result.reorderLogFiles(logs))));
    }
}
