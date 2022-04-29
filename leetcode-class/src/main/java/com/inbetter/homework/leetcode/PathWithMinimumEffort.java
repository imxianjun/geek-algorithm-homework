package com.inbetter.homework.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    private static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int n = heights.length;
        int m = heights[0].length;
        Integer[][] minimumDistances = new Integer[n][m];
        minimumDistances[0][0] = 0;
        priorityQueue.offer(new Integer[]{0, 0, 0});
        while (!priorityQueue.isEmpty()) {
            Integer[] currentPoint = priorityQueue.poll();
            if (currentPoint[0] == n - 1 && currentPoint[1] == m - 1) {
                return currentPoint[2];
            }
            for (int[] direction : directions) {
                int nx = currentPoint[0] + direction[0];
                int ny = currentPoint[1] + direction[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                int effort = Math.max(currentPoint[2], Math.abs(heights[currentPoint[0]][currentPoint[1]] - heights[nx][ny]));
                if (minimumDistances[nx][ny] == null || minimumDistances[nx][ny] > effort) {
                    minimumDistances[nx][ny] = effort;
                    priorityQueue.offer(new Integer[]{nx, ny, minimumDistances[nx][ny]});
                }
            }
        }
        return -1;
    }

}
