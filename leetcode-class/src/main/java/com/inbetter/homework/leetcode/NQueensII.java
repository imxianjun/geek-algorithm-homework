package com.inbetter.homework.leetcode;

import java.util.*;

public class NQueensII {

    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> positiveDiagonals = new HashSet<>();
    private Set<Integer> negativeDiagonals = new HashSet<>();

    public int totalNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        backtracking(list, new ArrayList<String>(), 0, n);
        return list.size();
    }

    private void backtracking(List<List<String>> list, ArrayList<String> boards, int row, int n) {
        if (row == n) {
            list.add(new ArrayList<>(boards));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || positiveDiagonals.contains(row + col) || negativeDiagonals.contains(row - col)) {
                continue;
            }

            char[] board = new char[n];
            Arrays.fill(board, '.');
            board[col] = 'Q';
            boards.add(new String(board));

            cols.add(col);
            positiveDiagonals.add(row + col);
            negativeDiagonals.add(row - col);

            backtracking(list, boards, row + 1, n);

            boards.remove(boards.size()-1);
            cols.remove(col);
            positiveDiagonals.remove(row + col);
            negativeDiagonals.remove(row - col);
        }
    }

}
