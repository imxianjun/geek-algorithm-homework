package com.inbetter.homework.leetcode;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[] ans = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                ans[j] = triangle.get(i).get(j) + Math.min(ans[j], ans[j + 1]);
            }
        }
        return ans[0];
    }

}
