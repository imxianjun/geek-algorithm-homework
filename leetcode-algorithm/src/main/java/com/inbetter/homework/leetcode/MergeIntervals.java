package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return null;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedList = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (mergedList.size() == 0 || mergedList.get(mergedList.size() - 1)[1] < left) {
                mergedList.add(new int[]{left, right});
            } else {
                mergedList.get(mergedList.size() - 1)[1] = Math.max(mergedList.get(mergedList.size() - 1)[1], right);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }

}
