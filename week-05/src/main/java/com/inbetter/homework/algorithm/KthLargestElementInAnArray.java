package com.inbetter.homework.algorithm;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int l, int r, int index) {
        if (l >= r) {
            return nums[l];
        }
        int pivot = partition(nums, l, r);
        if (index <= pivot) {
            return quickSort(nums, l, pivot, index);
        } else {
            return quickSort(nums, pivot + 1, r, index);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = l + (int) (Math.random() * (r - l + 1));
        int pivotVal = nums[pivot];
        while (l <= r) {
            while (nums[l] < pivotVal) {
                l++;
            }
            while (nums[r] > pivotVal) {
                r--;
            }
            if (l == r) {
                break;
            }
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
        return r;
    }

}
