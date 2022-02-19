package com.inbetter.homework.leetcode;

import java.util.PriorityQueue;

public class MinimizeDeviationInArray {

    public int minimumDeviation(int[] nums) {
        Integer min = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (num % 2 == 1) {
                num = num * 2;
            }
            queue.add(-num);
            min = Math.min(min, num);
        }
        while (!queue.isEmpty()) {
            Integer value = -queue.poll();
            ans = Math.min(ans, value - min);
            if (value % 2 == 1) {
                break;
            }
            min = Math.min(min, value / 2);
            queue.add(-value / 2);
        }
        return ans;
    }

}
