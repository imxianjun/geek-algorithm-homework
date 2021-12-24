package com.inbetter.homework.leetcode;

public class JumpGameII {

    public int jump(int[] nums) {
        int end = 0, maxPosition = 0, steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = new int[]{1, 1, 3, 1, 4};
        int jump = jumpGameII.jump(nums);
        System.out.println(jump);
    }

}
