package com.inbetter.homework.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        grid[0][0] = 1;

        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] point = queue.poll();
                if (point[0] == m - 1 && point[1] == n - 1) {
                    return point[2];
                }
                for (int[] dir : dirs) {
                    int r = point[0] + dir[0];
                    int c = point[1] + dir[1];
                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 0) {
                        queue.add(new int[]{r, c, point[2] + 1});
                        grid[r][c] = 1;
                    }
                }
            }
        }
        return -1;
    }

}
