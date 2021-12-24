package com.inbetter.homework.leetcode;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;

        int[][] table = new int[coins.length + 1][amount + 1];

        for (int col = 1; col < table[0].length; col++) {
            table[0][col] = max;
        }

        for (int row = 1; row < table.length; row++) {
            int coin = coins[row - 1];
            for (int col = 1; col < table[row].length; col++) {
                if (coin > col) {
                    table[row][col] = table[row - 1][col];
                } else {
                    table[row][col] = Math.min(table[row - 1][col], table[row][col - coin] + 1);
                }
            }
        }

        int[] lastRow = table[table.length - 1];
        int lastElement = lastRow[lastRow.length - 1];

        return lastElement == max ? -1 : lastElement;
    }

}
