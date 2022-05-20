package com.inbetter.homework.leetcode;

public class LongestIncreasingPathInAMatrix {

    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int length = dfs(matrix, i, j, m, n, cache);
                max = Math.max(length, max);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int length = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, length);
        }
        cache[i][j] = max;
        return max;
    }

}
