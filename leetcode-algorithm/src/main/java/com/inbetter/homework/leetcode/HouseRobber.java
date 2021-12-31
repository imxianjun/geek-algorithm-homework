package com.inbetter.homework.leetcode;

public class HouseRobber {

    public int rob(int[] nums) {
        int previousMax = 0, currentMax = 0;
        for (int num : nums) {
            int temp = currentMax;
            currentMax = Math.max(previousMax + num, currentMax);
            previousMax = temp;
        }
        return currentMax;
    }

}
