package com.inbetter.homework.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSums {

    int length = 0;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        length = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int index, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (length <= index) {
            return ans;
        }
        if (k == 2) {
            int i = index, j = length - 1;
            while (i < j) {
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    ans.add(temp);

                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }

                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }

                    i++;
                    j--;
                } else if (target - nums[i] > nums[j]) {
                    i++;
                } else {
                    j--;
                }
            }
        } else {
            for (int i = index; i < length - k + 1; i++) {
                List<List<Integer>> temp = kSum(nums, target - nums[i], i + 1, k - 1);
                if (temp != null) {
                    for (List<Integer> list : temp) {
                        list.add(0, nums[i]);
                    }
                    ans.addAll(temp);
                }
                while (i < length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return ans;
    }

}
