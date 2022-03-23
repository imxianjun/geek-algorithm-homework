package com.inbetter.homework.leetcode;

public class BrokenCalculator {

    public int brokenCalc(int startValue, int target) {
        int count = 0;
        while (target > startValue) {
            target = target % 2 == 0 ? target / 2 : target + 1;
            count++;
        }
        return count + startValue - target;
    }

    public static void main(String[] args) {
        BrokenCalculator brokenCalculator = new BrokenCalculator();
        brokenCalculator.brokenCalc(8, 3);
    }

}
