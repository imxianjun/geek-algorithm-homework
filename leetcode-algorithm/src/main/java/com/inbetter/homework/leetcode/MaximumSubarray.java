package com.inbetter.homework.leetcode;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-1, -2, -3};
        System.out.println(new MaximumSubarray().maxSubArray(array));
    }

}
