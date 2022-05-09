package com.inbetter.homework.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        char[] chars = digits.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - '0';
            while (ans.peek().length() == i) {
                String remove = ans.remove();
                for (char c : mapping[index].toCharArray()) {
                    ans.addLast(remove + c);
                }
            }
        }
        return ans;
    }

}
