package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<List<Integer>>> adjacent = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int w = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                List<Integer> list = new ArrayList<>();
                list.add(j);
                list.add(w);
                adjacent.get(i).add(list);

                list = new ArrayList<>();
                list.add(i);
                list.add(w);
                adjacent.get(j).add(list);
            }
        }

        int ans = 0;
        int edges = 0;
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(new PointSort());
        priorityQueue.add(new Point(0, 0, 0));
        int[] visited = new int[n];
        while (edges != n) {
            Point dir = priorityQueue.poll();
            if (visited[dir.u] == 0 || visited[dir.v] == 0) {
                int v = 0;
                if (visited[dir.u] == 0) {
                    v = dir.u;
                } else {
                    v = dir.v;
                }

                visited[dir.u] = 1;
                visited[dir.v] = 1;
                ans += dir.w;

                edges++;

                for (List<Integer> list : adjacent.get(v)) {
                    Integer vv = list.get(0);
                    Integer ww = list.get(1);
                    priorityQueue.add(new Point(v, vv, ww));
                }
            }
        }

        return ans;
    }

    class PointSort implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            if (o1.w < o2.w) {
                return -1;
            } else if (o1.w > o2.w) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    class Point {
        int u;
        int v;
        int w;

        public Point(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

}
