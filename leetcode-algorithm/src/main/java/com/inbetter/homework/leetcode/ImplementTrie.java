package com.inbetter.homework.leetcode;

public class ImplementTrie {

    private TireNode root;

    public ImplementTrie() {
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
