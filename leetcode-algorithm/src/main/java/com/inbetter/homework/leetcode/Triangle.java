package com.inbetter.homework.leetcode;

import java.util.Arrays;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int dp[][] = new int[row][col];
        for (int i = 0; i < col; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return min(0, 0, triangle, dp);
    }

    public int min(int row, int col, List<List<Integer>> al, int dp[][]) {
        if (al.size() - 1 == row) {
            return al.get(row).get(col);
        }
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        int below = al.get(row).get(col) + min(row + 1, col, al, dp);
        int diagnol = al.get(row).get(col) + min(row + 1, col + 1, al, dp);
        return dp[row][col] = Math.min(below, diagnol);
    }

}
