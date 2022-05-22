package com.inbetter.homework.leetcode;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += isPalindromic(i, i, chars);
            count += isPalindromic(i, i + 1, chars);
        }
        return count;
    }

    private int isPalindromic(int left, int right, char[] chars) {
        int count = 0;
        while (left >= 0 && right < chars.length && chars[left--] == chars[right++]) {
            count++;
        }
        return count;
    }

}
