package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        int[] refunds = new int[n * 2];
        int minimum = 0, index = 0;
        for (int[] cost : costs) {
            refunds[index++] = cost[1] - cost[0];
            minimum += cost[0];
        }
        Arrays.sort(refunds);
        for (int i = 0; i < n; i++) {
            minimum += refunds[i];
        }
        return minimum;
    }

}
