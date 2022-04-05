package com.inbetter.homework.leetcode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, ans = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > ans) {
                ans = area;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }

}
