package com.inbetter.homework.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = null;
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Queue<Integer> queue = map.get(target - numbers[i]);
            if (queue == null || queue.isEmpty()) {
                queue = new LinkedList<>();
                queue.add(i);
                map.put(numbers[i], queue);
            } else {
                ans = new int[2];
                ans[0] = queue.peek() + 1;
                ans[1] = i + 1;
            }
        }
        return ans;
    }

}
