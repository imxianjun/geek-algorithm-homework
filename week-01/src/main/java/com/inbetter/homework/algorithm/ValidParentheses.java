package com.inbetter.homework.algorithm;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char character : chars) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (character == ')' && stack.peek() != '(') {
                    return false;
                }
                if (character == ']' && stack.peek() != '[') {
                    return false;
                }
                if (character == '}' && stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
