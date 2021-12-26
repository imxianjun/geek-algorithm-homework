package com.inbetter.homework.algorithm;

public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, ans = 0, maxLength = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                ans = cnt[i];
            } else if (dp[i] == maxLength) {
                ans += cnt[i];
            }
        }
        return ans;
    }

}
