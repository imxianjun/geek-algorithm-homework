package com.inbetter.homework.leetcode;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean searched = false;
        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = matrix[i];
            if (currentRow[0] <= target && currentRow[currentRow.length - 1] >= target) {
                for (int value : matrix[i]) {
                    if (value == target) {
                        searched = true;
                        break;
                    }
                }
            }
        }
        return searched;
    }

}
