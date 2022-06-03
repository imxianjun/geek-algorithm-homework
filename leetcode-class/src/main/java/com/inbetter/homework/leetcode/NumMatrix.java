package com.inbetter.homework.leetcode;

public class NumMatrix {

    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sumRegion = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sumRegion += matrix[i][j];
            }
        }
        return sumRegion;
    }

}
