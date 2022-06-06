package com.inbetter.homework.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NQueensII3 {

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> positiveDiagonals = new HashSet<>();
    private Set<Integer> negativeDiagonals = new HashSet<>();

    public int totalNQueens(int n) {
        return backtracking(0, 0, n);
    }

    private int backtracking(int row, int count, int n) {
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || positiveDiagonals.contains(row + col) || negativeDiagonals.contains(row - col)) {
                continue;
            }

            if (row == n - 1) {
                count++;
            } else {
                cols.add(col);
                positiveDiagonals.add(row + col);
                negativeDiagonals.add(row - col);

                count = backtracking(row + 1, count, n);

                cols.remove(col);
                positiveDiagonals.remove(row + col);
                negativeDiagonals.remove(row - col);
            }
        }
        return count;
    }

}
