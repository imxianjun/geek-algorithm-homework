package com.inbetter.homework.algorithm;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    private Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int y = stack.pop();
                int x = stack.pop();
                Integer value = calculate(x, y, token);
                stack.push(value);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private Integer calculate(Integer x, Integer y, String token) {
        if ("+".equals(token)) {
            return x + y;
        }
        if ("-".equals(token)) {
            return x - y;
        }
        if ("/".equals(token)) {
            return x / y;
        }
        if ("*".equals(token)) {
            return x * y;
        }
        return 0;
    }

}
