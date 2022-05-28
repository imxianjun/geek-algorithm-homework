package com.inbetter.homework.leetcode;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int max = nums[0], sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        int total = (max + 1) * max / 2;
        if (total - sum == 0 && nums.length == max) {
            return 0;
        }
        return total - sum == 0 ? max + 1 : total - sum;
    }

}
