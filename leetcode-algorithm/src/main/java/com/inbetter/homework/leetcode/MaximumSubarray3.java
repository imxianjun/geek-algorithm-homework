package com.inbetter.homework.leetcode;

public class MaximumSubarray3 {

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }

        int mid = i + (j - i) / 2;

        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;

        int sum = 0;
        for (int k = mid; k >= i; k--) {
            sum += nums[k];
            if (leftMax < sum) {
                leftMax = sum;
            }
        }

        sum = 0;
        for (int k = mid + 1; k <= j; k++) {
            sum += nums[k];
            if (rightMax < sum) {
                rightMax = sum;
            }
        }

        int maxLeftAndRight = Math.max(helper(nums, i, mid), helper(nums, mid + 1, j));
        return Math.max(maxLeftAndRight, leftMax + rightMax);
    }

}
