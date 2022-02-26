package com.inbetter.homework.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathVisitingAllNodes {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i, 1 << i);
            queue.offer(node);
            visited.add(node.toString());
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.mask == fullMask) {
                    return level;
                }
                for (int next : graph[node.id]) {
                    Node nextNode = new Node(next, node.mask | (1 << next));
                    if (visited.contains(nextNode.toString())) {
                        continue;
                    }
                    queue.offer(nextNode);
                    visited.add(nextNode.toString());
                }
            }
            level++;
        }
        return level;
    }

    class Node {
        int id;
        int mask;

        Node(int id, int mask) {
            this.id = id;
            this.mask = mask;
        }

        @Override
        public String toString() {
            return id + " " + mask;
        }
    }

}
