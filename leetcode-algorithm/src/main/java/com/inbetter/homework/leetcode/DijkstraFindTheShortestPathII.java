package com.inbetter.homework.leetcode;

import java.util.*;

public class DijkstraFindTheShortestPathII {

    private static int n;

    private static Map<Integer, List<Node>> adjacentNode;

    private static int[] distances;

    private static Set<Integer> minimumDistances = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();

        adjacentNode = new HashMap<>();
        distances = new int[n + 1];

        while (m-- > 0) {
            int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
            if (!adjacentNode.containsKey(a)) {
                adjacentNode.put(a, new ArrayList<>());
            }
            adjacentNode.get(a).add(new Node(b, c));
        }

        dijkstra();

        if (distances[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(distances[n]);
        }
    }

    private static void dijkstra() {
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        heap.offer(new int[]{1, 0});

        while (!heap.isEmpty()) {
            int[] t = heap.poll();
            int ver = t[0], distance = t[1];
            if (minimumDistances.contains(ver)) {
                continue;
            } else {
                minimumDistances.add(ver);
            }
            List<Node> nodes = adjacentNode.get(ver);
            if (nodes == null) {
                continue;
            }
            for (Node node : nodes) {
                int idx = node.idx;
                if (distances[idx] > distance + node.d) {
                    distances[idx] = distance + node.d;
                    heap.offer(new int[]{idx, distances[idx]});
                }
            }
        }
    }

    public static class Node {

        public int idx;

        public int d;

        public Node(int idx, int d) {
            this.idx = idx;
            this.d = d;
        }
    }

}
