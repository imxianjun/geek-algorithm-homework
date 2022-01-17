package com.inbetter.homework.leetcode;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int left = i, right = i;
            while (left >= 0 && s.charAt(left) == c) {
                left--;
            }
            while (right < s.length() && s.charAt(right) == c) {
                right++;
            }
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            left++;
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }
        return s.substring(start, end);
    }

}
