package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordFilter {

    Trie prefix = null;
    Trie suffix = null;

    public WordFilter(String[] words) {
        prefix = new Trie();
        suffix = new Trie();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            prefix.insert(word, i);
            suffix.insert(new StringBuilder(word).reverse().toString(), i);
        }
    }

    public int f(String pre, String suff) {
        List<Integer> prefixIndexes = prefix.startsWith(pre);
        List<Integer> suffixIndexes = suffix.startsWith(new StringBuilder(suff).reverse().toString());

        int i = prefixIndexes.size() - 1, j = suffixIndexes.size() - 1;
        while (i >= 0 && j >= 0) {
            if (Objects.equals(prefixIndexes.get(i), suffixIndexes.get(j))) {
                return prefixIndexes.get(i);
            } else if (prefixIndexes.get(i) > suffixIndexes.get(j)) {
                i--;
            } else {
                j--;
            }
        }
        return -1;
    }

    class Trie {
        private Trie[] t;
        private List<Integer> indexes;

        Trie() {
            t = new Trie[26];
            indexes = new ArrayList<>();
        }

        public void insert(String word, int index) {
            Trie root = this;
            for (char c : word.toCharArray()) {
                if (root.t[c - 'a'] == null) {
                    root.t[c - 'a'] = new Trie();
                }
                root = root.t[c - 'a'];
                root.indexes.add(index);
            }
        }

        public List<Integer> startsWith(String word) {
            Trie root = this;
            for (char c : word.toCharArray()) {
                if (root.t[c - 'a'] == null) {
                    return new ArrayList<>();
                }
                root = root.t[c - 'a'];
            }
            return root.indexes;
        }
    }

}
