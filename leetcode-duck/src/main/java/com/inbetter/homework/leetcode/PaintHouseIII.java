package com.inbetter.homework.leetcode;

public class PaintHouseIII {

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n][target + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= target; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (houses[0] == 0) {
                dp[0][j][1] = cost[0][j];
            } else if (houses[0] == j + 1) {
                dp[0][j][1] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int k = 1; k <= target && k <= i + 1; k++) {
                for (int j = 0; j < n; j++) {
                    if (houses[i] != 0 && houses[i] != j + 1) {
                        continue;
                    }

                    int costToPaint = houses[i] == j + 1 ? 0 : cost[i][j];

                    for (int t = 0; t < n; t++) {
                        if (j == t && dp[i - 1][t][k] != -1) {
                            dp[i][j][k] = dp[i][j][k] == -1 ?
                                    costToPaint + dp[i - 1][t][k] :
                                    Math.min(dp[i][j][k], costToPaint + dp[i - 1][t][k]);
                        } else if (j != t && dp[i - 1][t][k - 1] != -1) {
                            dp[i][j][k] = dp[i][j][k] == -1 ?
                                    costToPaint + dp[i - 1][t][k - 1] :
                                    Math.min(dp[i][j][k], costToPaint + dp[i - 1][t][k - 1]);
                        }
                    }
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (dp[m - 1][i][target] != -1) {
                ans = ans == -1 ? dp[m - 1][i][target] :
                        Math.min(ans, dp[m - 1][i][target]);
            }
        }
        return ans;
    }

}
