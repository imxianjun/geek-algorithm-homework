package com.inbetter.homework.leetcode;

public class SortArrayByParity2 {

    public int[] sortArrayByParity(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                swap(nums, i, j);
                i++;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,1,2,4};
        new SortArrayByParity2().sortArrayByParity(array);
    }

}
