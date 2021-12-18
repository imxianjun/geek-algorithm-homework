package com.inbetter.homework.leetcode;

public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int guess(int num) {
        return 0;
    }

}
