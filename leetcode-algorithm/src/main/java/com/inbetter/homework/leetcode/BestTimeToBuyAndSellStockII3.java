package com.inbetter.homework.leetcode;

public class BestTimeToBuyAndSellStockII3 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int min = Math.min(prices[i], prices[i + 1]);
            profit += prices[i + 1] - min;
        }
        return profit;
    }

}
