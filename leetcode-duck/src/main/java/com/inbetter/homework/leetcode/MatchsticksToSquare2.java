package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class MatchsticksToSquare2 {

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        int side = sum / 4;
        return makesquare(matchsticks, matchsticks.length - 1, new int[]{side, side, side, side});
    }

    private boolean makesquare(int[] matchsticks, int i, int[] sides) {
        if (i < 0) {
            return sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0;
        }
        for (int j = 0; j < sides.length; j++) {
            if (matchsticks[i] > sides[j]) {
                continue;
            }
            sides[j] -= matchsticks[i];
            if (makesquare(matchsticks, i - 1, sides)) {
                return true;
            }
            sides[j] += matchsticks[i];
        }
        return false;
    }

}
