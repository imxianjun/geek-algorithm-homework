package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Shift2DGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int start = m * n - (k % (m * n));
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        for (int s = start; s < m * n + start; s++) {
            int t = s % (m * n);
            int i = t / n;
            int j = t % n;
            if ((s - start) % n == 0) {
                ans.add(new ArrayList<>());
            }
            ans.peekLast().add(grid[i][j]);
        }
        return ans;
    }

}
