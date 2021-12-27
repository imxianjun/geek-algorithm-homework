package com.inbetter.homework.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> ans = new ArrayList<>();
        int farthest = -1;
        int start = -1;
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (left <= farthest) {
                farthest = Math.max(farthest, right);
            } else {
                if (farthest != -1) {
                    ans.add(new int[]{start, farthest});
                }
                start = left;
                farthest = right;
            }
        }
        ans.add(new int[]{start, farthest});
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        new MergeIntervals().merge(nums);
    }

}
