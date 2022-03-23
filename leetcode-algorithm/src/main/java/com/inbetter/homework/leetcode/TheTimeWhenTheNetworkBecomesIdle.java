package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TheTimeWhenTheNetworkBecomesIdle {

    private List<Integer>[] adj;
    private int[] min;
    private boolean[] visited;

    void dfs(int i, int level) {
        for (Integer ele : adj[i]) {
            if (visited[ele]) {
                if (min[ele] > level * 2) {

                    min[ele] = level * 2;
                    dfs(ele, level + 1);
                }
                continue;
            }
            visited[ele] = true;
            min[ele] = level * 2;
            dfs(ele, level + 1);
        }
    }

    public int networkBecomesIdle(int[][] arr, int[] pat) {
        int i, n = pat.length;

        adj = new ArrayList[n];
        min = new int[n];
        visited = new boolean[n];
        visited[0] = true;

        for (i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (i = 0; i < arr.length; i++) {
            adj[arr[i][0]].add(arr[i][1]);
            adj[arr[i][1]].add(arr[i][0]);
        }

        dfs(0, 1);

        int max = 0;
        for (i = 1; i < n; i++) {
            if (adj[i].size() == 0) {
                continue;
            }
            if (pat[i] >= min[i]) {
                max = Math.max(max, min[i]);
            } else {
                max = Math.max(max, min[i] + pat[i] * ((int) Math.ceil(min[i] / (double) pat[i]) - 1));
            }
        }
        return max + 1;
    }

}
