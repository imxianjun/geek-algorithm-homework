package com.inbetter.homework.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        priorityQueue.add(new int[]{0, 0, 0});
        boolean[] visited = new boolean[n];
        int cost = 0, edges = 0;
        while (!priorityQueue.isEmpty() || edges < n - 1) {
            int[] current = priorityQueue.remove();
            if (visited[current[1]]) {
                continue;
            }
            visited[current[1]] = true;
            cost += current[2];
            edges += 1;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    priorityQueue.add(new int[]{current[1], i,
                            Math.abs(points[current[1]][0] - points[i][0]) +
                                    Math.abs(points[current[1]][1] - points[i][1])});
                }
            }
        }
        return cost;
    }

}
