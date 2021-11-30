package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * mine
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0, k);
        return list;
    }

    private void backtrack(List<List<Integer>> list,
                           List<Integer> tempList,
                           int[] nums,
                           int start,
                           int depth) {
        if (tempList != null && tempList.size() == depth) {
            list.add(new ArrayList<Integer>(tempList));
        }
        for (int i = start; i < nums.length; i++) {
            if (tempList.size() >= depth) {
                break;
            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1, depth);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> combine = combinations.combine(4, 1);
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println("===");
        }
    }

}
