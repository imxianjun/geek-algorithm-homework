package com.inbetter.homework.leetcode;

public class SpiralMatrixII {

    private static final int[][] dirs = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int[][] generateMatrix(int n) {
        boolean[][] visited = new boolean[n][n];
        int[][] ans = new int[n][n];
        int value = 1, visitedCount = 0, i = 0, j = -1;
        while (visitedCount != n * n) {
            for (int[] dir : dirs) {
                while (isValid(ans, i + dir[0], j + dir[1]) && !visited[i + dir[0]][j + dir[1]]) {
                    i += dir[0];
                    j += dir[1];
                    ans[i][j] = value++;
                    visited[i][j] = true;
                    visitedCount++;
                }
            }
        }
        return ans;
    }

    private boolean isValid(int[][] ans, int i, int j) {
        return i >= 0 && i < ans.length && j >= 0 && j < ans[0].length;
    }

}
