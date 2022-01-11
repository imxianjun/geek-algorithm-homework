package com.inbetter.homework.algorithm;

public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetter(stringBuilder.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetter(stringBuilder.charAt(j))) {
                j--;
            }
            stringBuilder.setCharAt(i, s.charAt(j));
            stringBuilder.setCharAt(j, s.charAt(i));
        }
        return stringBuilder.toString();
    }

}
