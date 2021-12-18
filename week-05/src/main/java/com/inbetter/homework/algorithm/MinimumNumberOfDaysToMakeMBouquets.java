package com.inbetter.homework.algorithm;

public class MinimumNumberOfDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        int latestBloom = 0;
        for (int bloom : bloomDay) {
            latestBloom = Math.max(latestBloom, bloom);
        }
        int left = 0, right = latestBloom + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (validateOnDay(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (right == latestBloom + 1) {
            return -1;
        }
        return right;
    }

    private boolean validateOnDay(int[] bloomDay, int m, int k, int now) {
        int bouquet = 0;
        int consecutive = 0;
        for (int bloom : bloomDay) {
            if (bloom <= now) {
                consecutive++;
                if (consecutive == k) {
                    bouquet++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }
        return bouquet >= m;
    }

}
