package com.inbetter.homework.leetcode;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int k) {
        k -= n;
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        while (k > 0) {
            ans[--n] += Math.min(k, 25);
            k -= Math.min(k, 25);
        }
        return new String(ans);
    }

}
