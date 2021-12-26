package com.inbetter.homework.leetcode;

public class MaximumSubarray2 {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }

}
