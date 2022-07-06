package com.inbetter.homework.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestConsecutive = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int m = num + 1;
                while (set.contains(m)) {
                    m++;
                }
                longestConsecutive = Math.max(longestConsecutive, m - num);
            }
        }
        return longestConsecutive;
    }

}
