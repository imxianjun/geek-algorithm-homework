package com.inbetter.homework.algorithm;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[right]) {
                // true 1
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }

}
