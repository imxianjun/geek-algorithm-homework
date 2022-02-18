package com.inbetter.homework.leetcode;

import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (length <= k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < length) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();

        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }

        return stringBuilder.toString();
    }

}
