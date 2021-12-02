package com.inbetter.homework.leetcode;

import javafx.stage.PopupWindow;

public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / x * myPow(1 / x, -(n + 1));
        }

        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        double v = new Pow().myPow(-2, -10);
        System.out.println(v);
    }

}
