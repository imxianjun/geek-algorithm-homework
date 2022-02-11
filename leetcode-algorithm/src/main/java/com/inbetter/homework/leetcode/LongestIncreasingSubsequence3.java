package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence3 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, res, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == res) {
                res++;
            }
        }
        return res;
    }

}
