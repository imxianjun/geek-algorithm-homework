package com.inbetter.homework.leetcode;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue() {
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        int val = peek();
        output.pop();
        return val;
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.isEmpty();
    }

}
