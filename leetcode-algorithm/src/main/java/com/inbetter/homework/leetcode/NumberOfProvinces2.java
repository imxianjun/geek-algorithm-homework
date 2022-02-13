package com.inbetter.homework.leetcode;

public class NumberOfProvinces2 {

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length <= 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(isConnected);

        int n = isConnected.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    class UnionFind {
        private int count = 0;
        private int[] rank;
        private int[] parent;

        public UnionFind(int[][] isConnected) {
            int n = isConnected.length;
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int findRoot(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            if (rootP == rootQ) {
                return;
            }
            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] tests = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = new NumberOfProvinces2().findCircleNum(tests);
        System.out.println(circleNum);
    }

}
