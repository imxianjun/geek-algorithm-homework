package com.inbetter.homework.leetcode;

public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] maxProfits = new int[length + 1][3];
        maxProfits[0][1] = -prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfits[i][0] = Math.max(maxProfits[i - 1][0], maxProfits[i - 1][2]);
            maxProfits[i][1] = Math.max(maxProfits[i - 1][1], maxProfits[i - 1][0] - prices[i]);
            maxProfits[i][2] = maxProfits[i - 1][1] + prices[i];
            ans = Math.max(Math.max(maxProfits[i][0], maxProfits[i][1]), maxProfits[i][2]);
        }

        return ans;
    }

    public static void print(int[][] maxProfits){
        for (int i = 0; i < maxProfits.length; i++)
            for (int j = 0; j < maxProfits[0].length; j++)
                System.out.println("arr[" + i + "][" + j + "] = "
                        + maxProfits[i][j]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        new BestTimeToBuyAndSellStockWithCooldown().maxProfit(prices);
    }

}
