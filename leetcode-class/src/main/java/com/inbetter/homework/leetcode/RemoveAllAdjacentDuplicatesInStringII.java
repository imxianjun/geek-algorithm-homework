package com.inbetter.homework.leetcode;

public class RemoveAllAdjacentDuplicatesInStringII {

    public String removeDuplicates(String s, int k) {
        int i = 0, n = s.length();
        int[] count = new int[n];
        char[] chars = s.toCharArray();
        for (int j = 0; j < n; i++, j++) {
            chars[i] = chars[j];
            count[i] = i > 0 && chars[i - 1] == chars[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) {
                i -= k;
            }
        }
        return new String(chars, 0, i);
    }

}
