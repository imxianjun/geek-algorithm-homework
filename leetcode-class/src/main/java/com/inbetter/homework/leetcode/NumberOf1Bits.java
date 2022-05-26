package com.inbetter.homework.leetcode;

public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }

}
