package com.inbetter.homework.leetcode;

public class TrappingRainWater {

    public int trap(int[] height) {
        int ans = 0;
        int length = height.length;
        for (int i = 1; i < length - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            for (int j = i; j < length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            ans += Math.min(maxRight, maxLeft) - height[i];
        }
        return ans;
    }

}
