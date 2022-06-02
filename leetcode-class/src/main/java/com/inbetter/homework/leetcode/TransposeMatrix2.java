package com.inbetter.homework.leetcode;

public class TransposeMatrix2 {

    public int[][] transpose(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        if (row == col) {
            return transposeSquare(row, matrix);
        }
        int[][] flippedMatrix = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                flippedMatrix[j][i] = matrix[i][j];
            }
        }
        return flippedMatrix;
    }

    private int[][] transposeSquare(int m, int[][] matrix) {
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                swap(matrix, i, j);
            }
        }
        return matrix;
    }

    private void swap(int[][] matrix, int i, int j) {
        matrix[i][j] = matrix[i][j] ^ matrix[j][i];
        matrix[j][i] = matrix[i][j] ^ matrix[j][i];
        matrix[i][j] = matrix[i][j] ^ matrix[j][i];
    }

}
