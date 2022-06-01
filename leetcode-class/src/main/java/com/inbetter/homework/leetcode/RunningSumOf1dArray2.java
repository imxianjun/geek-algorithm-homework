package com.inbetter.homework.leetcode;

public class RunningSumOf1dArray2 {

    public int[] runningSum(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            nums[i] += nums[i - 1];
            i++;
        }
        return nums;
    }

}
