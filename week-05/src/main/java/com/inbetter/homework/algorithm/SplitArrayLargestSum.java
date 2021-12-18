package com.inbetter.homework.algorithm;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right) {
            int mid = (right + left) / 2;
            if (validate(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean validate(int[] nums, int m, int size) {
        int box = 0, count = 1;
        for (int num : nums) {
            if (box + num <= size) {
                box += num;
            } else {
                count++;
                box = num;
            }
        }
        return count <= m;
    }

}
