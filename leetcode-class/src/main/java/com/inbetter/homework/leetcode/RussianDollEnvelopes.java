package com.inbetter.homework.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length < 2) {
            return envelopes.length;
        }
        Arrays.sort(envelopes, new EnvelopeComparator());
        int[] dp = new int[envelopes.length];
        int size = 0;

        for (int[] envelope : envelopes) {
            int left = 0, right = size, middle = 0;
            while (left < right) {
                middle = left + (right - left) / 2;
                if (dp[middle] < envelope[1]) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            dp[left] = envelope[1];
            if (left == size) {
                size++;
            }
        }
        return size;
    }

    static class EnvelopeComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] e1, int[] e2) {
            return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
        }
    }

}
