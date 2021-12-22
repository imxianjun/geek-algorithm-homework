package com.inbetter.homework.algorithm;

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        for (int w : weights) {
            min = Math.max(min, w);
            max += w;
        }
        int returnCapacity = 0;

        while (min <= max) {
            int midCapacity = (min + max) / 2;
            int daysRequired = countDaysRequired(weights, midCapacity);

            if (daysRequired > days) {
                min = midCapacity + 1;
            } else {
                returnCapacity = midCapacity;
                max = midCapacity - 1;
            }
        }
        return returnCapacity;
    }

    public int countDaysRequired(int[] weights, int capacity) {
        int days = 1;
        int count = 0;
        for (int w : weights) {
            count += w;
            if (count > capacity) {
                days++;
                count = w;
            }
        }
        return days;
    }

}
