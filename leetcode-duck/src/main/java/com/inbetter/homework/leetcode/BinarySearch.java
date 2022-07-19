package com.inbetter.homework.leetcode;

public class BinarySearch {

    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
