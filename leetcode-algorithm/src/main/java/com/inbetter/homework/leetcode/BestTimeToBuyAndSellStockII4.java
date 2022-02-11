package com.inbetter.homework.leetcode;

public class BestTimeToBuyAndSellStockII4 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] maxProfits = new int[length + 1][2];
        for (int j = length - 1; j >= 0; j--) {
            for (int l = 0; l < 2; l++) {
                int doNoting = maxProfits[j + 1][l];
                int doSomething;
                if (l == 0) {
                    doSomething = maxProfits[j + 1][1] - prices[j];
                } else {
                    doSomething = maxProfits[j + 1][0] + prices[j];
                }
                maxProfits[j][l] = Math.max(doNoting, doSomething);
            }
        }
        return maxProfits[0][0];
    }

}
