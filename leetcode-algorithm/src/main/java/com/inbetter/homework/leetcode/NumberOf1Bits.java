package com.inbetter.homework.leetcode;

public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            c += (n & 1);
            n >>>= 1;
        }
        return c;
    }

}
