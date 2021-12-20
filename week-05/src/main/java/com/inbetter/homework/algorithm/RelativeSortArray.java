package com.inbetter.homework.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2Orders = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            arr2Orders.put(arr2[i], i);
        }

        int left=0,right=arr1.length-1;
        while (left<right){
            while (left<arr1.length&&arr2Orders.get(arr1[left])!=)
        }

        return arr1;
    }

}
