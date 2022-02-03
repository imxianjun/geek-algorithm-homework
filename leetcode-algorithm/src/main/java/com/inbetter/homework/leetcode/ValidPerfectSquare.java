package com.inbetter.homework.leetcode;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int left = 1, right = num;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (mid == num / mid && 0 == num % mid) {
                return true;
            } else if (mid > num / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
