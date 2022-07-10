package com.inbetter.homework.leetcode;

public class MinCostClimbingStairs4 {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0], second = cost[1];
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        return Math.min(first, second);
    }

}
