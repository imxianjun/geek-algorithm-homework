package com.inbetter.homework.leetcode;

public class ValidSudoku2 {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!isValid(board, i, j, c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == c) {
                return false;
            }
            if (i != col && board[row][i] == c) {
                return false;
            }
            if (row != (3 * (row / 3) + i / 3)
                    && col != (3 * (col / 3) + i % 3)
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

}
