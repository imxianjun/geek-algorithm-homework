package com.inbetter.homework.algorithm;

public class Sqrtx {

    public int mySqrt(int x) {
        // find max ans , require ans*ans<=x
        int left = 1, right = x;
        while (left < right) {
            int mid = (right + left + 1) / 2;
            if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public int myRealSqrt(int x) {
        double left = 0, right = x;
        while (right - left > 1e-7) {
            double mid = (right + left + 1) / 2.0;
            if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (int) right;
    }

}
