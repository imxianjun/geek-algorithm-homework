package com.inbetter.homework.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = countMap.get(c);
            if (count == null) {
                return false;
            }
            if (count == 1) {
                countMap.remove(c);
            } else {
                countMap.put(c, count - 1);
            }
        }
        return true;
    }

}
