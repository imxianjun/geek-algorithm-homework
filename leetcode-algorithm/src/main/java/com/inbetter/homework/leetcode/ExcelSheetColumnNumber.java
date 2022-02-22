package com.inbetter.homework.leetcode;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toUpperCase().toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum *= 26;
            sum += c - 'A' + 1;
        }
        return sum;
    }

}
