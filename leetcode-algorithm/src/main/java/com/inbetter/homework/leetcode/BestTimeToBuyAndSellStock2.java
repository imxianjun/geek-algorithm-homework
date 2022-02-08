package com.inbetter.homework.leetcode;

public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices == null || prices.length == 0) {
            return maxProfit;
        }
        int soFarMinPrice = prices[0];
        for (int price : prices) {
            if (soFarMinPrice < price) {
                maxProfit = Math.max(maxProfit, price - soFarMinPrice);
            } else {
                soFarMinPrice = price;
            }
        }
        return maxProfit;
    }

}
