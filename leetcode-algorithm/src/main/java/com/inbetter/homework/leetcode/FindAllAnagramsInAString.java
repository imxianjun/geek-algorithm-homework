package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int left = 0, right = 0;
        int[] a1 = new int[26];
        int[] a2 = new int[26];

        List<Integer> ans = new ArrayList<>();

        while (right < p.length()) {
            a1[s.charAt(right) - 'a']++;
            a2[p.charAt(right) - 'a']++;
            right++;
        }

        right--;

        while (right < s.length()) {
            if (Arrays.equals(a1, a2)) {
                ans.add(left);
            }
            right++;
            if (right < s.length()) {
                a1[s.charAt(right) - 'a']++;
            }
            a1[s.charAt(left) - 'a']--;
            left++;
        }
        return ans;
    }

}
