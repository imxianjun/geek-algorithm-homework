package com.inbetter.homework.leetcode;

public class BitwiseAndOfNumbersRange {

    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0) {
            return 0;
        }
        int moveFactor = 1;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            moveFactor <<= 1;
        }
        return left * moveFactor;
    }

}
