package com.inbetter.homework.leetcode;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int begin = -1, end = -2;
        int minimum = nums[n - 1], maximum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maximum = Math.max(maximum, nums[i]);
            minimum = Math.min(minimum, nums[n - 1 - i]);
            if (nums[i] < maximum) {
                end = i;
            }
            if (nums[n - 1 - i] > minimum) {
                begin = n - 1 - i;
            }
        }
        return end - begin + 1;
    }

}
