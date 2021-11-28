package com.inbetter.homework.algorithm;

public class TwoSum2 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int j = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            while (i < j && (nums[i] + nums[j] > target)) {
                j--;
            }
            if (i < j && (nums[i] + nums[j] == target)) {
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -1, -18, -19};
        int target = -19;
        int[] ints = new TwoSum2().twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println(ints);
    }

}
