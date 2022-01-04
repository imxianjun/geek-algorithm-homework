package com.inbetter.homework.algorithm;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] mem = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mem[i][j] = -1;
            }
        }
        return palindromeSubseq(s, 0, s.length() - 1, mem);
    }

    private int palindromeSubseq(String s, int low, int high, int[][] mem) {
        if (low == high) {
            return 1;
        }
        if (low > high) {
            return 0;
        }
        if (s.charAt(low) == s.charAt(high)) {
            if (mem[low + 1][high - 1] == -1) {
                mem[low + 1][high - 1] = palindromeSubseq(s, low + 1, high - 1, mem);
            }
            return 2 + mem[low + 1][high - 1];
        } else {
            if (mem[low + 1][high] == -1) {
                mem[low + 1][high] = palindromeSubseq(s, low + 1, high, mem);
            }
            if (mem[low][high - 1] == -1) {
                mem[low][high - 1] = palindromeSubseq(s, low, high - 1, mem);
            }
            return Math.max(mem[low + 1][high], mem[low][high - 1]);
        }
    }

}
