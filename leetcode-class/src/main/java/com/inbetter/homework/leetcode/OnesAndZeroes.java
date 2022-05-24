package com.inbetter.homework.leetcode;

public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int one = 0, zero = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    ++zero;
                } else {
                    ++one;
                }
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    if (i >= zero && j >= one) {
                        dp[i][j] = Math.max(1 + dp[i - zero][j - one], dp[i][j]);
                    }
                }
            }
        }
        return dp[m][n];
    }

}
