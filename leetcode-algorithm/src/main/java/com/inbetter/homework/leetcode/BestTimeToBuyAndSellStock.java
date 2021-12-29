package com.inbetter.homework.leetcode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0, soFarMin = prices[0];
        for (int price : prices) {
            if (price > soFarMin) {
                max = Math.max(max, price - soFarMin);
            } else {
                soFarMin = price;
            }
        }
        return max;
    }

}
