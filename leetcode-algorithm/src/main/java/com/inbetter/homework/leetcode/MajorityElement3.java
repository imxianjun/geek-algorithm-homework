package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class MajorityElement3 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
