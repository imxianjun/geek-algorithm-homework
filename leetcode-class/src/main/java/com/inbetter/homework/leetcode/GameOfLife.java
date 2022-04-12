package com.inbetter.homework.leetcode;

public class GameOfLife {

    private static final int[][] dirs = new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1}, {0, 1},
            {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        playGame(board, rows, cols);
        updateBoard(board, rows, cols);
    }

    private void updateBoard(int[][] board, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private void playGame(int[][] board, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int alive = aliveNeighbors(board, rows, cols, i, j);
                if (board[i][j] == 0 && alive == 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && (alive == 2 || alive == 3)) {
                    board[i][j] = 3;
                }
            }
        }
    }

    private int aliveNeighbors(int[][] board, int rows, int cols, int i, int j) {
        int alive = 0;
        for (int[] dir : dirs) {
            int neighborX = i + dir[0];
            int neighborY = j + dir[1];
            if (!isOutOfBoards(rows, cols, neighborX, neighborY)) {
                alive += board[neighborX][neighborY] & 1;
            }
        }
        return alive;
    }

    private boolean isOutOfBoards(int rows, int cols, int x, int y) {
        return x < 0 || y < 0 || x >= rows || y >= cols;
    }

}
