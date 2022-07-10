package com.inbetter.homework.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class JumpGameVI {

    public int maxResult(int[] nums, int k) {
        int length = nums.length;
        int[] maxResults = new int[length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int previousMaxResult = deque.isEmpty() ? 0 : maxResults[deque.peekFirst()];
            maxResults[i] = nums[i] + previousMaxResult;
            while (!deque.isEmpty() && maxResults[deque.peekLast()] < maxResults[i]) {
                deque.pollLast();
            }
            deque.add(i);
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
        }
        return maxResults[length - 1];
    }

}
