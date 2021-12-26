package com.inbetter.homework.algorithm;

public class RelativeSortArrayWithCount {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int val : arr1) {
            count[val]++;
        }

        int[] ans = new int[arr1.length];
        int index = 0;

        for (int val : arr2) {
            for (int i = 0; i < count[val]; ++i) {
                ans[index++] = val;
            }
            count[val] = 0;
        }

        for (int val = 0; val <= 1000; val++) {
            for (int i = 0; i < count[val]; ++i) {
                ans[index++] = val;
            }
        }

        return ans;
    }

}
