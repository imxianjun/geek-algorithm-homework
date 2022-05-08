package com.inbetter.homework.algorithm;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> container;
    private Stack<Integer> previousMinimum;

    public MinStack() {
        container = new Stack<>();
        previousMinimum = new Stack<>();
    }

    public void push(int val) {
        container.push(val);
        if (previousMinimum.isEmpty()) {
            previousMinimum.push(val);
        } else {
            previousMinimum.push(Math.min(previousMinimum.peek(), val));
        }
    }

    public void pop() {
        container.pop();
        previousMinimum.pop();
    }

    public int top() {
        return container.peek();
    }

    public int getMin() {
        return previousMinimum.peek();
    }

}
