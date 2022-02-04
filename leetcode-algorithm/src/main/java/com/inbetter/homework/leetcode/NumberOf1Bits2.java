package com.inbetter.homework.leetcode;

public class NumberOf1Bits2 {

    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            c++;
            n = n & (n - 1);
        }
        return c;
    }

}
