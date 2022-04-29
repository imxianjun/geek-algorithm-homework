package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestStringWithSwaps {

    private int[] parent;

    private int[] rank;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        for (int i = 0; i < n; i++) {
            parent[i] = find(parent[i]);
        }

        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Character> list = map.getOrDefault(parent[i], new ArrayList<>());
            list.add(s.charAt(i));
            map.put(parent[i], list);
        }

        for (List<Character> value : map.values()) {
            value.sort((x, y) -> y - x);
        }

        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = map.get(parent[i]).remove(map.get(parent[i]).size() - 1);
        }

        return new String(chars);
    }

    private void union(int a, int b) {
        int x = find(a), y = find(b);
        if (x == y) {
            return;
        }
        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[x] = y;
            rank[y]++;
        }
    }

    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

}
