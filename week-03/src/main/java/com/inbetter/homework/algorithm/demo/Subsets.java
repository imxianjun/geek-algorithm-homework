package com.inbetter.homework.algorithm.demo;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private int n;

    private List<Integer> chosen = new ArrayList<Integer>();

    private List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums,
                       int i) {
        if (i == n) {
            ans.add(new ArrayList<Integer>(chosen));
            return;
        }
        recur(nums, i + 1);
        chosen.add(nums[i]);
        recur(nums, i + 1);
        chosen.remove(chosen.size() - 1);
    }

}
