package com.leetcode.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class FirstUniqueCharacterInAString {
    // Better solution
    public int firstUniqChar(String s) {
        int count[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

//    public int firstUniqChar(String s) {
//        Map<Character, Integer> characters = new HashMap<>();
//        int result = -1;
//
//        if (Objects.isNull(s) || s.length() == 0) {
//            return result;
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            if (!characters.containsKey(s.charAt(i))) {
//                characters.put(s.charAt(i), 0);
//            }
//            characters.put(s.charAt(i), characters.get(s.charAt(i))+1);
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            if (characters.get(s.charAt(i)) == 1) {
//                result = i;
//                break;
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString test = new FirstUniqueCharacterInAString();
        String input = "leetcode";
        int result = test.firstUniqChar(input);
        System.out.println(result == 0);

        input = "loveleetcode";
        result = test.firstUniqChar(input);
        System.out.println(result == 2);

        input = "aabb";
        result = test.firstUniqChar(input);
        System.out.println(result == -1);

        input = "abaccdeff";
        result = test.firstUniqChar(input);
        System.out.println(input.charAt(result) == 'b');

        input = "aabccd";
        result = test.firstUniqChar(input);
        System.out.println(input.charAt(result) == 'b');
    }
}
