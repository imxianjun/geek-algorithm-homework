package com.inbetter.homework.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {

    public boolean hasAllCodes(String s, int k) {
        if (s.length() == 1) {
            return false;
        }
        Set<String> subStrings = new HashSet<>();
        char[] chars = s.toCharArray();
        int total = (int) Math.pow(2, k);
        for (int i = 0; i < chars.length - k + 1; i++) {
            if(subStrings.size() >= total){
                return true;
            }
            String temp = "";
            for (int j = 0; j < k; j++) {
                temp += chars[i + j];
            }
            subStrings.add(temp);
        }
        return subStrings.size() >= total;
    }

}
