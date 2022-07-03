package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class MaximumUnitsOnATruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int maximumUnits = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize >= boxType[0]) {
                maximumUnits += boxType[1] * boxType[0];
                truckSize -= boxType[0];
            } else {
                maximumUnits += truckSize * boxType[1];
                return maximumUnits;
            }
        }
        return maximumUnits;
    }

}
