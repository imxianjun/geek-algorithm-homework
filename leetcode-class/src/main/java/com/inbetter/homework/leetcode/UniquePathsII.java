package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class UniquePathsII {

    private int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dfs(obstacleGrid, 0, 0, m, n);
    }

    private int dfs(int[][] obstacleGrid, int row, int col, int m, int n) {
        if (row < 0 || col < 0 || row >= m || col >= n || obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if(dp[row][col]>1){
            return dp[row][col];
        }
        dp[row][col]=dfs(obstacleGrid, row+1, col, m, n)+dfs(obstacleGrid, row, col+1, m, n);
        return dp[row][col];
    }

}
