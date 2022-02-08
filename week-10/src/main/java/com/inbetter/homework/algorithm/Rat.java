package com.inbetter.homework.algorithm;

import java.util.*;

public class Rat {

    static class Node implements Comparable<Node> {

        private int x;

        private int y;

        private int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Node o) {
            if (this.z == o.z) {
                if (this.x + this.y == o.x + o.y) {
                    return o.x - this.x;
                }
                return o.x + o.y - this.x + this.y;
            }
            return this.z - o.z;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] mice = new int[n][2];
            for (int i = 0; i < n; i++) {
                mice[i][0] = scanner.nextInt();
                mice[i][1] = scanner.nextInt();
            }

            int[][] flower = new int[m][2];
            for (int i = 0; i < m; i++) {
                flower[i][0] = scanner.nextInt();
                flower[i][1] = scanner.nextInt();
            }

            Map<String, Integer> miceCounter = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String key = mice[i][0] + "_" + mice[i][1];
                miceCounter.put(key, miceCounter.getOrDefault(key, 0) + 1);
            }

            Set<String> flowerSet = new HashSet<>();
            for (int i = 0; i < m; i++) {
                String key = flower[i][0] + "_" + flower[i][1];
                if (!flowerSet.contains(key)) {
                    flowerSet.add(key);
                }
            }

            TreeSet<Node> treeSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                String key = mice[i][0] + "_" + mice[i][1];
                int count = miceCounter.getOrDefault(key, 0);
                if (flowerSet.contains(key)) {
                    continue;
                }
                treeSet.add(new Node(mice[i][0], mice[i][1], count));
            }

            Node node = treeSet.last();
            System.out.print(node.x + " " + node.y);
        }
    }
}

