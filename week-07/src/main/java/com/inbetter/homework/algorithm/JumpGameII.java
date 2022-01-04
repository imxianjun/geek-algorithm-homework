package com.inbetter.homework.algorithm;

public class JumpGameII {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = Integer.MAX_VALUE;
        }
        pre[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= i + nums[i] && j < n; j++) {
                pre[j] = Math.min(pre[j], pre[i] + 1);
            }
        }
        return pre[n - 1];
    }

}
