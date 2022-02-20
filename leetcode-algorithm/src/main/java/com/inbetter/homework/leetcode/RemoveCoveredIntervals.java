package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        int ans = 0, right = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });
        for (int[] interval : intervals) {
            if (interval[1] > right) {
                ans++;
                right = interval[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Comp comp1 = new Comp(1);
        Comp comp2 = new Comp(2);
        Comp comp3 = new Comp(3);
        Comp comp4 = new Comp(4);

        List<Comp> comps = new ArrayList<>();
        comps.add(comp3);
        comps.add(comp4);
        comps.add(comp1);
        comps.add(comp2);

        for (Comp comp : comps) {
            System.out.println(comp.value);
        }

        comps.sort(new CompSort());

        System.out.println("=====");

        for (Comp comp : comps) {
            System.out.println(comp.value);
        }
    }

    static class Comp {

        private int value;

        public Comp() {
        }

        public Comp(int value) {
            this.value = value;
        }
    }

    static class CompSort implements Comparator<Comp> {
        @Override
        public int compare(Comp o1, Comp o2) {
            return o2.value - o1.value;
        }
    }

}
