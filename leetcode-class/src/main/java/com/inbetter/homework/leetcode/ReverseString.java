package com.inbetter.homework.leetcode;

public class ReverseString {

    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n >> 1; i++) {
            char temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
    }

}
