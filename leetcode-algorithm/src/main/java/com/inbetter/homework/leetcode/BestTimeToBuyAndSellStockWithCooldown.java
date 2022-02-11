package com.inbetter.homework.leetcode;

public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][][] maxProfits = new int[length + 1][length + 1][2];
        for (int i = 1; i <= length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                for (int l = 0; l < 2; l++) {
                    int doNoting = maxProfits[j + 1][i][l];
                    int doSomething;
                    if (l == 0) {
                        doSomething = maxProfits[j + 1][i][1] - prices[j];
                    } else {
                        doSomething = maxProfits[j + 1][i - 1][0] + prices[j];
                    }
                    maxProfits[j][i][l] = Math.max(doNoting, doSomething);
                }
            }
        }
        return maxProfits[0][length][0];
    }

}
