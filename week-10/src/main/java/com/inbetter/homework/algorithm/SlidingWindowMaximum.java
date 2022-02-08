package com.inbetter.homework.algorithm;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if (n==0||k==0){
            return new int[0];
        }
        int numOfWindow=n-k+1;
        int[] result=new int[numOfWindow];
//        for (int start = 0; start < numOfWindow; start++) {
//            int end=start+k-1;
//            int maxVal=
//        }
        return nums;
    }

}
