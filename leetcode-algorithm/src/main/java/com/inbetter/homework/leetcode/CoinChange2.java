package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class CoinChange2 {

    public int coinChange(int[] coins, int amount) {
        int maxAmount = amount + 1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, maxAmount);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int i = new CoinChange2().coinChange(coins, 11);
        System.out.println(i);
    }

}
