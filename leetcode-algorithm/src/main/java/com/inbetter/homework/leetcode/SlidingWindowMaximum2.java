package com.inbetter.homework.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });
        for (int i = 0; i < length; i++) {
            int start = i - k;
            if (start >= 0) {
                maxQueue.remove(start);
            }
            maxQueue.offer(i);
            if (maxQueue.size() == k) {
                ans[i - k + 1] = nums[maxQueue.peek()];
            }
        }
        return ans;
    }

}
