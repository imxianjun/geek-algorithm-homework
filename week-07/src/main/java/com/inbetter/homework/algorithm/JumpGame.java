package com.inbetter.homework.algorithm;

public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums[0] >= nums.length - 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (i > nums[i - 1]) {
                return false;
            }
            if (i + nums[i] >= nums.length - 1) {
                return true;
            }
            nums[i] = Math.max(i + nums[i], nums[i - 1]);
        }
        return true;
    }

}
