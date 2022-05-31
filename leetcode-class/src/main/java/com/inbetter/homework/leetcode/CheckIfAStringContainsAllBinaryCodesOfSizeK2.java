package com.inbetter.homework.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK2 {

    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int val = 0, total = 1 << k;
        for (int i = 0; i < k; i++) {
            val = val * 2 + s.charAt(i) - '0';
        }
        set.add(val);
        for (int i = k; i < s.length() && set.size() < total; i++) {
            val = val * 2 + s.charAt(i) - '0';
            val -= (s.charAt(i - k) - '0') * (1 << k);
            set.add(val);
        }
        return set.size() == total;
    }

}
