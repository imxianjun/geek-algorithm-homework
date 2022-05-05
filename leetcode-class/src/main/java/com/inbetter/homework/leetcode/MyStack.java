package com.inbetter.homework.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> container = null;

    public MyStack() {
        container = new LinkedList<>();
    }

    public void push(int x) {
        container.add(x);
        for (int i = 1; i < container.size(); i++) {
            container.add(container.remove());
        }
    }

    public int pop() {
        return container.remove();
    }

    public int top() {
        return container.peek();
    }

    public boolean empty() {
        return container.isEmpty();
    }

}
