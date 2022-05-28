package com.inbetter.homework.leetcode;

public class NumberOfStepsToReduceANumberToZero {

    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num >>= 1;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }

}
