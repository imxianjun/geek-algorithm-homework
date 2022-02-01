package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class MajorityElement2 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
