package com.inbetter.homework.algorithm.demo;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    private int n, k;

    private List<Integer> chosen = new ArrayList<Integer>();

    private List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        recur(1);
        return ans;
    }

    private void recur(int i) {
        // 剪枝
        if (chosen.size() > k || (chosen.size() + (n - i + 1) < k)) {
            return;
        }
        if (i == n + 1) {
            if (chosen.size() == k) {
                ans.add(new ArrayList<Integer>(chosen));
            }
            return;
        }
        recur(i + 1);
        chosen.add(i);
        recur(i + 1);
        chosen.remove(chosen.size() - 1);
    }

}
