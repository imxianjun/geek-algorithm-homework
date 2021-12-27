package com.inbetter.homework.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergeIntervals2 {

    public int[][] merge(int[][] intervals) {
        Map<Integer, Integer> events = new TreeMap<>();
        for (int[] interval : intervals) {
            events.put(interval[0], events.getOrDefault(interval[0], 0) + 1);
            events.put(interval[1], events.getOrDefault(interval[1], 0) - 1);
        }
        int covering = 0;
        int start = 0;
        List<int[]> ans = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : events.entrySet()) {
            if (covering == 0) {
                start = entry.getKey();
            }
            covering += entry.getValue();
            if (covering == 0) {
                ans.add(new int[]{start, entry.getKey()});
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 4}, {4, 5}};
        int[][] merge = new MergeIntervals2().merge(nums);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
