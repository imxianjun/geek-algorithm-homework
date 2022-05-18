package com.inbetter.homework.leetcode;

import java.util.*;

public class CriticalConnectionsInANetwork {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }
        Set<List<Integer>> set = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(graph, 0, 0, rank, set);
        return new ArrayList<>(set);
    }

    private int dfs(List<Integer>[] graph, int node, int depth, int[] rank, Set<List<Integer>> set) {
        if (rank[node] >= 0) {
            return rank[node];
        }
        rank[node] = depth;
        int minimumFoundDepth = depth;
        for (Integer neighbor : graph[node]) {
            if (rank[neighbor] == depth - 1) {
                continue;
            }
            int minimumDepth = dfs(graph, neighbor, depth + 1, rank, set);
            minimumFoundDepth = Math.min(minimumDepth, minimumFoundDepth);
            if (minimumDepth <= depth) {
                set.remove(Arrays.asList(node, neighbor));
                set.remove(Arrays.asList(neighbor, node));
            }
        }
        return minimumFoundDepth;
    }

}
