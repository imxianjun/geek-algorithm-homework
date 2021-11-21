package com.inbetter.homework.algorithm;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] plusArray = new int[n + 1];
        plusArray[0] = 1;
        return plusArray;
    }

}
