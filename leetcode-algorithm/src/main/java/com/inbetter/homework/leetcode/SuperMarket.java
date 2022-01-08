package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SuperMarket {

    private static int n;

    private static int[] fa;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            fa = new int[10001];
            for (int i = 1; i < 10001; i++) {
                fa[i] = i;
            }
            List<Pair> profitWithExpiredDays = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                Pair pair = new Pair();
                pair.profit = scanner.nextInt();
                pair.expiredDay = scanner.nextInt();
                profitWithExpiredDays.add(pair);
            }

            Collections.sort(profitWithExpiredDays);

            int maxProfits = 0;

            for (int i = n - 1; i >= 0; i--) {
                Pair pair = profitWithExpiredDays.get(i);
                int profit = pair.profit;
                int expiredDay = pair.expiredDay;
                int availableDay = find(expiredDay);
                if (availableDay > 0) {
                    maxProfits += profit;
                    fa[availableDay] = availableDay - 1;
                }
            }
            System.out.println(maxProfits);
        }
    }

    private static int find(int x) {
        if (x == fa[x]) {
            return x;
        }
        return fa[x] = find(fa[x]);
    }

    private static class Pair implements Comparable<Pair> {

        int profit;

        int expiredDay;

        @Override
        public int compareTo(Pair o) {
            return this.profit - o.profit;
        }
    }

}
