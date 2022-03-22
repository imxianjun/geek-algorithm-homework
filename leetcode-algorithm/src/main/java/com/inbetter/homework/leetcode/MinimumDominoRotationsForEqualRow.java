package com.inbetter.homework.leetcode;

public class MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countTop = new int[7],
                countBottoms = new int[7],
                same = new int[7];
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            countTop[tops[i]]++;
            countBottoms[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }
        for (int i = 1; i < 7; i++) {
            if (countBottoms[i] + countTop[i] - same[i] == n) {
                return n - Math.max(countTop[i], countBottoms[i]);
            }
        }
        return -1;
    }

}
