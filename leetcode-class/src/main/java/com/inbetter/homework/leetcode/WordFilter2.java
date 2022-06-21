package com.inbetter.homework.leetcode;

public class WordFilter2 {
    Trie root = null;

    public WordFilter2(String[] words) {
        root = new Trie();
        for (int weight = 0; weight < words.length; weight++) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); i++) {
                Trie current = root;
                current.weight = weight;
                for (int j = i; j < 2 * word.length() - 1; j++) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (current.t[k] == null) {
                        current.t[k] = new Trie();
                    }
                    current = current.t[k];
                    current.weight = weight;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        Trie current = root;
        for (char c : (suffix + '{' + prefix).toCharArray()) {
            if (current.t[c - 'a'] == null) {
                return -1;
            }
            current = current.t[c - 'a'];
        }
        return current.weight;
    }

    class Trie {
        private Trie[] t;
        private int weight;

        Trie() {
            t = new Trie[27];
            weight = 0;
        }
    }

}
