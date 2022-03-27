package com.inbetter.homework.leetcode;

import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            priorityQueue.offer(new int[]{numsOne(mat[i]), i});
            if (priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }

        while(k>0){
            ans[--k]=priorityQueue.poll()[1];
        }
        return ans;
    }

    private int numsOne(int[] rows) {
        int lo = 0, hi = rows.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (rows[mid] == 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

}
