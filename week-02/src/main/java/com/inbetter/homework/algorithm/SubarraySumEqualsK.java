package com.inbetter.homework.algorithm;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0, count = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (sumMap.containsKey(sum - k)) {
                count += sumMap.get(sum - k);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
