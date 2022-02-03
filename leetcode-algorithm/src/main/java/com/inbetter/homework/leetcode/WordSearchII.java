package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Tire tire = new Tire();
        for (String word : words) {
            tire.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, tire);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Tire tire) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }

        if (visited[x][y]) {
            return;
        }

        str += board[x][y];
        if (!tire.startsWith(str)) {
            return;
        }

        if (tire.search(str)) {
            res.add(str);
        }

        visited[x][y] = true;
        dfs(board, visited, str, x - 1, y, tire);
        dfs(board, visited, str, x + 1, y, tire);
        dfs(board, visited, str, x, y - 1, tire);
        dfs(board, visited, str, x, y + 1, tire);
        visited[x][y] = false;
    }

    class Tire {
        private TireNode root;

        public Tire() {
            root = new TireNode();
            root.val = ' ';
        }

        public void insert(String word) {
            TireNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    ws.children[c - 'a'] = new TireNode(c);
                }
                ws = ws.children[c - 'a'];
            }
            ws.isWord = true;
        }

        public boolean search(String word) {
            TireNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    return false;
                }
                ws = ws.children[c - 'a'];
            }
            return ws.isWord;
        }

        public boolean startsWith(String prefix) {
            TireNode ws = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    return false;
                }
                ws = ws.children[c - 'a'];
            }
            return true;
        }

        class TireNode {
            public char val;
            public boolean isWord;
            public TireNode[] children = new TireNode[26];

            public TireNode() {
            }

            TireNode(char c) {
                TireNode tireNode = new TireNode();
                tireNode.val = c;
            }
        }
    }

}
