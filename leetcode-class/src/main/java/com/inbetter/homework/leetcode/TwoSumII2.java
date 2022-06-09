package com.inbetter.homework.leetcode;

public class TwoSumII2 {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];

        if (numbers == null || numbers.length < 2) {
            return numbers;
        }

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int value = numbers[left] + numbers[right];
            if (value == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (value > target) {
                right--;
            } else {
                left++;
            }
        }

        return ans;
    }

}
