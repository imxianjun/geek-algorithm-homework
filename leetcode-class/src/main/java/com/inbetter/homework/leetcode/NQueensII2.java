package com.inbetter.homework.leetcode;

public class NQueensII2 {

    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] positiveDiagonals = new boolean[n * 2];
        boolean[] negativeDiagonals = new boolean[n * 2];
        backtracking(cols, positiveDiagonals, negativeDiagonals, 0, n);
        return count;
    }

    private void backtracking(boolean[] cols, boolean[] positiveDiagonals, boolean[] negativeDiagonals, int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col] || positiveDiagonals[row + col] || negativeDiagonals[row - col + n]) {
                continue;
            }

            cols[col] = true;
            positiveDiagonals[row + col] = true;
            negativeDiagonals[row - col + n] = true;

            backtracking(cols, positiveDiagonals, negativeDiagonals, row + 1, n);

            cols[col] = false;
            positiveDiagonals[row + col] = false;
            negativeDiagonals[row - col + n] = false;
        }
    }

}
