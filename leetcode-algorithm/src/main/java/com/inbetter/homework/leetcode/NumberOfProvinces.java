package com.inbetter.homework.leetcode;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int count = isConnected.length;
        int[] roots = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            roots[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    int rooti = findRoot(roots, i);
                    int rootj = findRoot(roots, j);
                    if (rooti != rootj) {
                        roots[rooti] = rootj;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    private int findRoot(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }

}
