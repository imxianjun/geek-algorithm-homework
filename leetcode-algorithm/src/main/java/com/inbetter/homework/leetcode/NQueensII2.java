package com.inbetter.homework.leetcode;

public class NQueensII2 {

    int count = 0;

    public int totalNQueens(int n) {
        if (n < 1) {
            return count;
        }
        dfs(n, 0, 0, 0, 0);
        return count;
    }

    private void dfs(int n, int row, int cols, int pie, int na) {
        if (row >= n) {
            count++;
            return;
        }
        // 得到当前所有的空位
        int bits = (~(cols | pie | na)) & ((1 << n) - 1);
        while (bits != 0) {
            int p = bits & -bits;
            dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1);
            bits = bits & (bits - 1);
        }
    }

}
