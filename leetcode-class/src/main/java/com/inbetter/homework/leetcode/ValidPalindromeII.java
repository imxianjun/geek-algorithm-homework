package com.inbetter.homework.leetcode;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return validPalindrome(chars, i + 1, j) || validPalindrome(chars, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean validPalindrome(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "axbcbaba";
//        String s = "cbbcc";
//        String s = "abc";
        boolean b = new ValidPalindromeII().validPalindrome(s);
        System.out.println(b);
    }

}
