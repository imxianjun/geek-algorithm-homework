package com.inbetter.homework.algorithm;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int end = words.length - 1;
        for (int i = 0; i <= end; i++) {
            if (!words[i].isEmpty()) {
                stringBuilder.insert(0, words[i]);
                if (i < end) {
                    stringBuilder.insert(0, " ");
                }
            }
        }
        return stringBuilder.toString();
    }

}
