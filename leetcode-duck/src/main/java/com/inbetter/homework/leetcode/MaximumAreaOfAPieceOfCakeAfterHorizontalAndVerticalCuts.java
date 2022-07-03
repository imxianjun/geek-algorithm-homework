package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxHorizontalArea = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int maxVerticalArea = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            maxHorizontalArea = Math.max(maxHorizontalArea, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        for (int i = 0; i < verticalCuts.length - 1; i++) {
            maxVerticalArea = Math.max(maxVerticalArea, verticalCuts[i + 1] - verticalCuts[i]);
        }
        return (int) ((long) maxHorizontalArea * (long) maxVerticalArea % (1000000007L));
    }

}
