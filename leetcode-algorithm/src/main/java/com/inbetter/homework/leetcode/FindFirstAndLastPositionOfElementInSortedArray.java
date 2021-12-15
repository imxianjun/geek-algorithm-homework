package com.inbetter.homework.leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        double left = target - 0.5, right = target + 0.5;
        int l = bs(nums, left);
        int r = bs(nums, right);
        if (l == r) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r - 1};
    }

    private int bs(int[] nums, double target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

}
