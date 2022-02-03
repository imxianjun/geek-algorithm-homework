package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens3 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        helper(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int n, int rowIdx, boolean[] cols, boolean[] d1, boolean[] d2, List<String> board, List<List<String>> ans) {
        if (rowIdx == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        char[] row = new char[n];
        Arrays.fill(row, '.');
        for (int colIdx = 0; colIdx < n; colIdx++) {
            int id1 = rowIdx - colIdx + n - 1;
            int id2 = n - colIdx - rowIdx + n - 2;
            if (!cols[colIdx] && !d1[id1] && !d2[id2]) {
                row[colIdx] = 'Q';
                board.add(new String(row));
                cols[colIdx] = d1[id1] = d2[id2] = true;
                helper(n, rowIdx + 1, cols, d1, d2, board, ans);
                row[colIdx] = '.';
                board.remove(board.size() - 1);
                cols[colIdx] = d1[id1] = d2[id2] = false;
            }
        }
    }

    public static void main(String[] args) {
        NQueens3 nQueens3 = new NQueens3();
        List<List<String>> lists = nQueens3.solveNQueens(4);
        lists.forEach(System.out::println);
    }

}
