package com.inbetter.homework.algorithm;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        ans[0] = right;

        left = -1;
        right = nums.length - 1;
        while (left < right) {
            int mid = (right + left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        ans[1] = right;

        if (ans[0] > ans[1]) {
            return new int[]{-1, -1};
        }
        return ans;
    }

}
