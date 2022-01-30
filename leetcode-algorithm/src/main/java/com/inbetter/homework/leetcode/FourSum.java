package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }

        int length = nums.length;
        Arrays.sort(nums);

        int i, z;
        for (i = 0; i < length; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1]) {
                continue;
            }
            if (4 * z == target) {
                if (i + 3 < length && nums[i + 3] == z) {
                    ans.add(Arrays.asList(z, z, z, z));
                }
                break;
            }
            threeSumForFourSum(nums, target - z, i + 1, length - 1, ans, z);
        }
        return ans;
    }

    private void threeSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> ans, int z1) {
        if (low + 1 >= high) {
            return;
        }
        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) {
                continue;
            }
            if (3 * z == target) {
                if (i + 1 < high && nums[i + 2] == z) {
                    ans.add(Arrays.asList(z1, z, z, z));
                }
                break;
            }
            twoSumForFourSum(nums, target - z, i + 1, high, ans, z1, z);
        }
    }

    private void twoSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> ans, int z1, int z2) {
        if (low >= high) {
            return;
        }
        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                ans.add(Arrays.asList(z1, z2, nums[i], nums[j]));
                x = nums[i];
                while (++i < j && x == nums[i]) {
                    ;
                }
                x = nums[j];
                while (i < --j && x == nums[j]) {
                    ;
                }
            }
            if (sum < target) {
                i++;
            }
            if (sum > target) {
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={0,0,0,1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> lists = new FourSum().fourSum(nums, 1000000000);
    }

}
