package com.inbetter.homework.leetcode;

public class MaximumProductSubarray2 {

    public int maxProduct(int[] nums) {
        int minimum = nums[0];
        int maximum = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(Math.max(maximum * nums[i], minimum * nums[i]), nums[i]);
            minimum = Math.min(Math.min(maximum * nums[i], minimum * nums[i]), nums[i]);
            maximum = temp;
            ans = Math.max(maximum, ans);
        }
        return ans;
    }

}
