package com.inbetter.homework.leetcode;

public class NumberOfIslands2 {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0)
            return 0;

        UnionFind uf = new UnionFind(grid);

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if (!(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) && grid[nextX][nextY] == '1') {
                            uf.union(i * n + j, nextX * n + nextY);
                        }
                    }
                }
            }
        }
        return uf.getCount();
    }


    class UnionFind {

        private int count = 0;
        private int[] rank;
        private int[] parent;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            rank = new int[m * n];
            parent = new int[m * n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = -1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }
        }

        private int findRoot(int i) {
            if (parent[i] != i)
                parent[i] = findRoot(parent[i]);
            return parent[i];
        }

        public boolean connected(int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        public void union(int p, int q) {
            int rootp = findRoot(p);
            int rootq = findRoot(q);
            if (rootp != rootq) {
                if (rank[rootp] > rank[rootq]) {
                    parent[rootq] = rootp;
                } else if (rank[rootp] < rank[rootq]) {
                    parent[rootp] = rootq;
                } else {
                    parent[rootq] = rootp;
                    rank[rootp] += 1;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public class QuickUnionUF {

        private int[] roots;

        public QuickUnionUF(int N) {
            roots = new int[N];
            for (int i = 0; i < N; i++) {
                roots[i] = i;
            }
        }

        private int findRoot(int i) {
            int root = i;
            while (root != roots[root]) {
                root = roots[root];
            }
            while (i != roots[i]) {
                int tmp = roots[i];
                roots[i] = root;
                i = tmp;
            }
            return root;
        }

        public boolean connected(int p, int q) {
            return findRoot(p) == findRoot(q);
        }

        public void union(int p, int q) {
            int qroot = findRoot(q);
            int proot = findRoot(p);
            roots[proot] = qroot;
        }
    }

}
