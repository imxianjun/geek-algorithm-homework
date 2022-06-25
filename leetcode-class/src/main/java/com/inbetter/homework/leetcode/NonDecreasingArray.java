package com.inbetter.homework.leetcode;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        boolean removed = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            if (removed) {
                return false;
            }
            removed = true;
            if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
                nums[i] = nums[i - 1];
            }
        }
        return true;
    }

}
