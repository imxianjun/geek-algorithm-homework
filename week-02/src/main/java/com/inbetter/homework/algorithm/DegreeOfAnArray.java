package com.inbetter.homework.algorithm;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(), firstIndex = new HashMap<>();
        int degree = 0, minimumLength = 0;
        for (int i = 0; i < nums.length; i++) {
            firstIndex.putIfAbsent(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if (count.get(nums[i]) > degree) {
                degree = count.get(nums[i]);
                minimumLength = i - firstIndex.get(nums[i]) + 1;
            }

            if (count.get(nums[i]) == degree) {
                minimumLength = Math.min(minimumLength, i - firstIndex.get(nums[i]) + 1);
            }
        }

        return minimumLength;
    }

}
