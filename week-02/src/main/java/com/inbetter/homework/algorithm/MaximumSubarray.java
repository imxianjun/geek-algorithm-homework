package com.inbetter.homework.algorithm;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        int[] preMin = new int[n + 1];
        s[0] = 0;
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        preMin[0] = s[0];
        for (int i = 1; i <= n; i++) {
            preMin[i] = Math.min(preMin[i - 1], s[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, s[i] - preMin[i - 1]);
        }
        return ans;
    }

}
