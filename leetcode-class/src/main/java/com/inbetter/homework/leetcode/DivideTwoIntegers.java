package com.inbetter.homework.leetcode;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) {
            return (1 << 31) - 1;
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if ((a >>> i) - b >= 0) {
                ans += 1 << i;
                a -= b << i;
            }
        }
        return dividend > 0 == divisor > 0 ? ans : -ans;
    }

    public static void main(String[] args) {
        new DivideTwoIntegers().divide(-1, -1);
        System.out.println(3^2);
    }

}
