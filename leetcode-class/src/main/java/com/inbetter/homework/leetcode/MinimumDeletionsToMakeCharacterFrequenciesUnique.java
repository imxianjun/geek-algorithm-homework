package com.inbetter.homework.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int minDeletions = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0 && !used.add(count[i])) {
                count[i]--;
                minDeletions++;
            }
        }
        return minDeletions;
    }

}
