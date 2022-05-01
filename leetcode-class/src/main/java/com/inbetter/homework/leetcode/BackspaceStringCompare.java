package com.inbetter.homework.leetcode;

import java.util.Stack;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> backspaceStringS = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                backspaceStringS.push(c);
            } else {
                if (!backspaceStringS.isEmpty()) {
                    backspaceStringS.pop();
                }
            }
        }
        Stack<Character> backspaceStringT = new Stack<>();
        for (char c : t.toCharArray()) {
            if (c != '#') {
                backspaceStringT.push(c);
            } else {
                if (!backspaceStringT.isEmpty()) {
                    backspaceStringT.pop();
                }
            }
        }
        String builderS = "";
        while (!backspaceStringS.isEmpty()) {
            builderS += backspaceStringS.pop();
        }
        String builderT = "";
        while (!backspaceStringT.isEmpty()) {
            builderT += backspaceStringT.pop();
        }
        return builderS.equals(builderT);
    }

}
