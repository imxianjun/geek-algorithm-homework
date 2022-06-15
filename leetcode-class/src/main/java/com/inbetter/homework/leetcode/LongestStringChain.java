package com.inbetter.homework.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        Map<String, Integer> memorization = new HashMap<>();
        int result = 0;
        for (String word : words) {
            memorization.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder(word);
                String next = stringBuilder.deleteCharAt(i).toString();
                if (memorization.containsKey(next)) {
                    memorization.put(word, Math.max(memorization.get(word), memorization.get(next) + 1));
                }
            }
            result = Math.max(result, memorization.get(word));
        }

        return result;
    }

}
