package com.inbetter.homework.algorithm;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals3 {

    public int[][] merge(int[][] intervals) {
        List<Pair<Integer, Integer>> events = new ArrayList<>();
        for (int[] interval : intervals) {
            events.add(new Pair(interval[0], 1));
            events.add(new Pair(interval[1] + 1, -1));
        }
        events.sort((e1, e2) -> e1.getKey().equals(e2.getKey()) ? e1.getValue() - e2.getValue() : e1.getKey() - e2.getKey());
        int covering = 0;
        int start = 0;
        List<int[]> ans = new LinkedList<>();
        for (Pair<Integer, Integer> event : events) {
            if (covering == 0) {
                start = event.getKey();
            }
            covering += event.getValue();
            if (covering == 0) {
                ans.add(new int[]{start, event.getKey() - 1});
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 4}, {4, 5}};
        int[][] merge = new MergeIntervals3().merge(nums);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
