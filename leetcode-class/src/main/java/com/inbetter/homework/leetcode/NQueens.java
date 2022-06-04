package com.inbetter.homework.leetcode;

import java.util.*;

public class NQueens {

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> positiveDiagonals = new HashSet<>();
    private Set<Integer> negativeDiagonals = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<String>(), 0, n);
        return ans;
    }

    private void backtracking(List<List<String>> ans, ArrayList<String> boards, int row, int n) {
        if (n == row) {
            ans.add(new ArrayList<>(boards));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (this.cols.contains(col) || negativeDiagonals.contains(row - col) || positiveDiagonals.contains(row + col)) {
                continue;
            }

            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[col] = 'Q';
            boards.add(String.valueOf(chars));

            cols.add(col);
            negativeDiagonals.add(row - col);
            positiveDiagonals.add(row + col);

            backtracking(ans, boards, row + 1, n);

            boards.remove(boards.size() - 1);

            cols.remove(col);
            negativeDiagonals.remove(row - col);
            positiveDiagonals.remove(row + col);
        }
    }

}
