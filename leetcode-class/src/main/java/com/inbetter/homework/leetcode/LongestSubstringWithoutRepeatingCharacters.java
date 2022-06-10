package com.inbetter.homework.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values,
     * and keep two pointers which define the max substring.
     * move the right pointer to scan through the string ,
     * and meanwhile update the hashmap. If the character is already in the hashmap,
     * then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int lengthOfLongestSubstring = 0;
        if (s == null || s.length() == 0) {
            return lengthOfLongestSubstring;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, right - left + 1);
        }
        return lengthOfLongestSubstring;
    }

}
