package com.inbetter.homework.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int sum = 0, maximumUniqueSubarrayTotalScore = 0;
        for (int left = 0, right = 0; right < nums.length; ) {
            if (seen.add(nums[right])) {
                sum += nums[right++];
                maximumUniqueSubarrayTotalScore = Math.max(sum, maximumUniqueSubarrayTotalScore);
            } else {
                sum -= nums[left];
                seen.remove(nums[left++]);
            }
        }
        return maximumUniqueSubarrayTotalScore;
    }

}
