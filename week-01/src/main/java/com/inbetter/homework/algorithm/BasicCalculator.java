package com.inbetter.homework.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {

    private Stack<Character> ops = new Stack<>();

    private Stack<Integer> stack = new Stack<>();

    public int calculate(String s) {
        s += " ";
        String number = "";
        List<String> tokens = new ArrayList<>();
        boolean needZero = true;
        char[] chars = s.toCharArray();
        for (char character : chars) {
            if (character >= '0' && character <= '9') {
                number += character;
                needZero = false;
                continue;
            } else {
                if (number != "") {
                    tokens.add(number);
                    number = "";
                }
            }
            if (character == ' ') {
                continue;
            }
            if (character == '(') {
                ops.push(character);
                needZero = true;
                continue;
            }
            if (character == ')') {
                while (ops.peek() != '(') {
                    tokens.add(String.valueOf(ops.pop()));
                }
                ops.pop();
                needZero = false;
                continue;
            }
            if ((character == '+' || character == '-') && needZero) {
                tokens.add("0");
            }
            int rank = getRank(character);
            while (!ops.isEmpty() && getRank(ops.peek()) >= rank) {
                tokens.add(String.valueOf(ops.pop()));
            }
            ops.push(character);
            needZero = true;
        }
        while (!ops.isEmpty()) {
            tokens.add(String.valueOf(ops.pop()));
        }
        return evalRPN(tokens.toArray(new String[tokens.size()]));
    }

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

    private int getRank(char character) {
        if (character == '*' || character == '/') {
            return 2;
        }
        if (character == '+' || character == '-') {
            return 1;
        }
        return 0;
    }

}
