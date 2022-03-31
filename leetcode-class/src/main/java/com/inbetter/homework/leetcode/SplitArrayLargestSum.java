package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 5][55];
        int[] sum = new int[n + 5];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                if (j == 1) {
                    dp[i][j] = sum[i];
                } else {
                    for (int k = 1; k <= i - 1; k++) {
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                    }
                }
            }
        }
        return dp[n][m];
    }

}
