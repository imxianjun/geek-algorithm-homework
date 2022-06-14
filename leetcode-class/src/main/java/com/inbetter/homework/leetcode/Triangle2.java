package com.inbetter.homework.leetcode;

import java.util.List;

public class Triangle2 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 0) {
            return 0;
        }
        int n = triangle.get(m - 1).size();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[m];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            int size = triangle.get(i).size();
            for (int j = size - 1; j >= 0; j--) {
                int current = Math.min((j < size - 1 ? dp[j] : Integer.MAX_VALUE),
                        (j >= 1 ? dp[j - 1] : Integer.MAX_VALUE)) + triangle.get(i).get(j);
                dp[j] = current;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            min = Math.min(min, dp[k]);
        }
        return min;
    }

}
