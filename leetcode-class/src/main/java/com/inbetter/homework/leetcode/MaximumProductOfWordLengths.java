package com.inbetter.homework.leetcode;

public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int length = words.length;
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            values[i] = 0;
            for (int j = 0; j < word.length(); j++) {
                values[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((values[i] & values[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            System.out.println(alphabet + ":" + Integer.toBinaryString(alphabet));
            System.out.println(1 << (alphabet - 'a'));
        }
    }
}
