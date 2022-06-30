package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int minMoves = 0;
        while (i < j) {
            minMoves += nums[j--] - nums[i++];
        }
        return minMoves;
    }

}
