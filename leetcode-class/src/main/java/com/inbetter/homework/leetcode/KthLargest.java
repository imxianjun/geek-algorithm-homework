package com.inbetter.homework.leetcode;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> priorityQueue;

    int k;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }

}
