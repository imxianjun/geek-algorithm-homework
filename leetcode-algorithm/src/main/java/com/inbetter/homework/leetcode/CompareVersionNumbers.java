package com.inbetter.homework.leetcode;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        int value1 = 0, value2 = 0;
        int length1 = version1.length(), length2 = version2.length();
        int i = 0, j = 0;
        while (i < length1 || j < length2) {
            value1 = 0;
            value2 = 0;
            while (i < length1 && version1.charAt(i) != '.') {
                value1 = value1 * 10 + version1.charAt(i++) - '0';
            }
            while (j < length2 && version2.charAt(j) != '.') {
                value2 = value2 * 10 + version2.charAt(j++) - '0';
            }
            if (value1 < value2) {
                return -1;
            } else if (value1 > value2) {
                return 1;
            } else {
                i++;
                j++;
            }
        }
        return 0;
    }

}
