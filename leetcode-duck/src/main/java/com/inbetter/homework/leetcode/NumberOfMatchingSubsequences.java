package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        List<StringBuilder>[] waiting = new List[128];
        for (int i = 0; i <= 'z'; i++) {
            waiting[i] = new ArrayList<>();
        }
        for (String word : words) {
            waiting[word.charAt(0)].add(new StringBuilder(word));
        }
        for (char c : s.toCharArray()) {
            List<StringBuilder> advance = waiting[c];
            waiting[c] = new ArrayList<>();
            for (StringBuilder it : advance) {
                it.deleteCharAt(0);
                if (it.length() != 0) {
                    waiting[it.charAt(0)].add(it);
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }

}
