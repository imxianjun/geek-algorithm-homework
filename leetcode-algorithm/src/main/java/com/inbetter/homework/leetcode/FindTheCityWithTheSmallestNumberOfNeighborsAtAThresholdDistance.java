package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        int res = 0, smallest = n;
        for (int[] row : dis) {
            Arrays.fill(row, 10001);
        }
        for (int[] edge : edges) {
            dis[edge[0]][edge[1]] = dis[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            dis[i][i] = 0;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dis[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= smallest) {
                res = i;
                smallest = count;
            }
        }
        return res;
    }

}
