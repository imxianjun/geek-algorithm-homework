package com.inbetter.homework.leetcode;

public class ValidParentheses2 {

    public boolean isValid(String s) {
        int length;
        do {
            length = s.length();
            s = s.replace("()", "")
                    .replace("{}", "")
                    .replace("[]", "");
        } while (length != s.length());
        return s.length() == 0;
    }

}
