package com.inbetter.homework.algorithm;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            max = Math.max((prices[i] - dp[i]), max);
        }
        return max;
    }

}
