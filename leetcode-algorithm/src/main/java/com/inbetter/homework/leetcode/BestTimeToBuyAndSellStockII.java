package com.inbetter.homework.leetcode;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0], peak = prices[0];
        int maxProfits = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxProfits += peak - valley;
        }
        return maxProfits;
    }

}
