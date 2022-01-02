package com.inbetter.homework.algorithm;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n <= 1)
            return 0;
        int maxProfit = 0, prevAns = 0, minPrice = prices[0];
        for(int i = 1; i < n; ++i){
            int currentProfit = prices[i] - fee - minPrice + prevAns;
            if(prevAns - minPrice < maxProfit - prices[i]){
                prevAns = maxProfit;
                minPrice = prices[i];
            }
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }

}
