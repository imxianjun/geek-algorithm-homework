package com.inbetter.homework.leetcode;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[amount - 1];
    }

}
