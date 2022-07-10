package com.inbetter.homework.leetcode;

public class MinCostClimbingStairs {

    /**
     * Time Limit Exceeded
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCostClimbingStairs(cost, n - 1), minCostClimbingStairs(cost, n - 2));
    }

    private int minCostClimbingStairs(int[] cost, int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return cost[n];
        }
        return cost[n] + Math.min(minCostClimbingStairs(cost, n - 1), minCostClimbingStairs(cost, n - 2));
    }

}
