package com.inbetter.homework.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2Orders = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            arr2Orders.put(arr2[i], i);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }

        list.sort((x, y) -> {
            if (arr2Orders.containsKey(x) || arr2Orders.containsKey(y)) {
                return arr2Orders.getOrDefault(x, 1001) - arr2Orders.getOrDefault(y, 1001);
            } else {
                return x - y;
            }
        });

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }

        return arr1;
    }

}
