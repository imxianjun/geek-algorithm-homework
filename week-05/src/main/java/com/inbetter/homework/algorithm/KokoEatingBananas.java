package com.inbetter.homework.algorithm;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1_000_000_000;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (!possible(piles, H, mi)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return lo;
    }

    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p : piles) {
            time += (p - 1) / K + 1;
        }
        return time <= H;
    }

}
