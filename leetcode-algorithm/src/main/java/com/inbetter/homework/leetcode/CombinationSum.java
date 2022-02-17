package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A general approach to backtracking questions in Java (Subsets, Permutations, Combination Sum, Palindrome Partitioning)
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> single, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            ans.add(new ArrayList<>(single));
        } else {
            for (int i = start; i < candidates.length; i++) {
                single.add(candidates[i]);
                backtracking(ans, single, candidates, remain - candidates[i], i);
                single.remove(single.size() - 1);
            }
        }
    }

}
