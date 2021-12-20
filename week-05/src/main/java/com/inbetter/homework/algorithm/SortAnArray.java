package com.inbetter.homework.algorithm;

public class SortAnArray {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = partition(nums, l, r);
        quickSort(nums, l, pivot);
        quickSort(nums, pivot + 1, r);
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
