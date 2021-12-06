package com.inbetter.homework.algorithm.demo;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private int n;

    private boolean[] used = null;

    private List<Integer> chosen = new ArrayList<Integer>();

    private List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        used = new boolean[n];
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int pos) {
        if (pos == n) {
            ans.add(new ArrayList<Integer>(chosen));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                chosen.add(nums[i]);
                used[i] = true;
                recur(nums, pos + 1);
                used[i] = false;
                chosen.remove(chosen.size() - 1);
            }
        }
    }

}
