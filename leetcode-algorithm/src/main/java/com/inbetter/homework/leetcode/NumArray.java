package com.inbetter.homework.leetcode;

public class NumArray {

    int[] nums;

    int[] bit;

    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        bit = new int[n + 1];
        for (int i = 0; i < n; i++) {
            init(i, nums[i]);
        }
    }

    private void init(int i, int val) {
        i++;
        while (i <= n) {
            bit[i] += val;
            i += (i & -i);
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        init(index, diff);
    }

    public int sumRange(int left, int right) {
        return getSum(right) - getSum(left - 1);
    }

    private int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += bit[i];
            i -= (i & -i);
        }
        return sum;
    }

}
