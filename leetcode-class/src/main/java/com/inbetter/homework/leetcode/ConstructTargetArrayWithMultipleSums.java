package com.inbetter.homework.leetcode;

import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {

    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        long total = 0;
        for (int number : target) {
            total += number;
            queue.add(number);
        }
        while (true) {
            int number = queue.poll();
            total -= number;
            if (number == 1 || total == 1) {
                return true;
            }
            if (number < total || total == 0 || number % total == 0) {
                return false;
            }
            number %= total;
            total += number;
            queue.add(number);
        }
    }

}
