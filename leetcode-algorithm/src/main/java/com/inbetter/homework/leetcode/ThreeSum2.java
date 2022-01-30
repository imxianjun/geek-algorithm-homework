package com.inbetter.homework.leetcode;

import java.util.*;

public class ThreeSum2 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            int target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(target - nums[j])) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], target - nums[j]);
                    Collections.sort(list);
                    ans.add(list);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(ans);
    }

}
