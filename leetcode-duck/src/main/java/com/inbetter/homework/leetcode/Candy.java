package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int length = ratings.length;
        if (length <= 1) {
            return length;
        }
        int[] numbers = new int[length];
        Arrays.fill(numbers, 1);
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                numbers[i] = numbers[i - 1] + 1;
            }
        }
        for (int i = length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                numbers[i - 1] = Math.max(numbers[i] + 1, numbers[i - 1]);
            }
        }
        int minimumNumber = 0;
        for (int i = 0; i < length; i++) {
            minimumNumber += numbers[i];
        }
        return minimumNumber;
    }

}
