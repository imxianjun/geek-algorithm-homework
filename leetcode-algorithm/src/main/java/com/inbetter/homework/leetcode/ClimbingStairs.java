package com.inbetter.homework.leetcode;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        int last = 1, options = 0;
        for (int i = 0; i <= n; i++) {
            int temp = last;
            last = options;
            options += temp;
        }
        return options;
    }

}
