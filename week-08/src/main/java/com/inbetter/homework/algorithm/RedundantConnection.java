package com.inbetter.homework.algorithm;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int[] sets = new int[edges.length + 1];
        for (int[] edge : edges) {
            int u = find(sets, edge[0]);
            int v = find(sets, edge[1]);
            if (u == v) {
                return edge;
            }
            sets[u] = v;
        }
        return new int[]{};
    }

    private int find(int[] sets, int v) {
        return sets[v] == 0 ? v : find(sets, sets[v]);
    }

}
