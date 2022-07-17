package com.inbetter.homework.leetcode;

public class OutOfBoundaryPaths {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m][n][maxMove + 1];
        return findPathsHelper(m, n, maxMove, startRow, startColumn, dp);
    }

    private int findPathsHelper(int m, int n, int move, int row, int column, Integer[][][] dp) {
        int mod = 1000000007;
        if (row < 0 || column < 0 || row >= m || column >= n) {
            return 1;
        }
        if (move <= 0) {
            return 0;
        }
        if (dp[row][column][move] != null) {
            return dp[row][column][move];
        }

        int count = 0;
        count = count % mod + findPathsHelper(m, n, move - 1, row - 1, column, dp) % mod;
        count = count % mod + findPathsHelper(m, n, move - 1, row + 1, column, dp) % mod;
        count = count % mod + findPathsHelper(m, n, move - 1, row, column - 1, dp) % mod;
        count = count % mod + findPathsHelper(m, n, move - 1, row, column + 1, dp) % mod;

        dp[row][column][move] = count % mod;

        return dp[row][column][move];
    }

}
