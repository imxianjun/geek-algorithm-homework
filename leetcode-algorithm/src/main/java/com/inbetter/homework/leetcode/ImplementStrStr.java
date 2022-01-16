package com.inbetter.homework.leetcode;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        if (len1 < len2) {
            return -1;
        } else if (len2 == 0) {
            return 0;
        }
        int threshold = len1 - len2;
        for (int i = 0; i <= threshold; i++) {
            if (haystack.substring(i, i + len2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
