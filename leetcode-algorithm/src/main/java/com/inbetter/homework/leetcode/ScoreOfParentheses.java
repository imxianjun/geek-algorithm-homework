package com.inbetter.homework.leetcode;

import java.util.Stack;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(current);
                current = 0;
            }
            if (c == ')') {
                current = stack.pop() + Math.max(current * 2, 1);
            }
        }
        return current;
    }

}
