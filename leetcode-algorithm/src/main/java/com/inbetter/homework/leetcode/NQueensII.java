package com.inbetter.homework.leetcode;

public class NQueensII {

    public int totalNQueens(int n) {
        int[][] attack = new int[n][n];
        return backtracking(0, n, attack);
    }

    private int backtracking(int d, int n, int[][] attack) {
        if (n == d) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (attack[d][i] == 0) {
                updateAttack(d, i, n, attack);
                count += backtracking(d + 1, n, attack);
                restoreAttack(d, i, n, attack);
            }
        }

        return count;
    }

    private void restoreAttack(int i, int j, int n, int[][] attack) {
        for (int k = i + 1, offset = 1; k < n; k++, offset++) {
            attack[k][j] += 1;
            if (j - offset >= 0) {
                attack[k][j - offset] += 1;
            }
            if (j + offset < n) {
                attack[k][j + offset] += 1;
            }
        }
    }

    private void updateAttack(int i, int j, int n, int[][] attack) {
        for (int k = i + 1, offset = 1; k < n; k++, offset++) {
            attack[k][j] -= 1;
            if (j - offset >= 0) {
                attack[k][j - offset] -= 1;
            }
            if (j + offset < n) {
                attack[k][j + offset] -= 1;
            }
        }
    }

}
