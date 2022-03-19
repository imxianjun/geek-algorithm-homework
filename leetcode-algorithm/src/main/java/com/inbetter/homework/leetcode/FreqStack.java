package com.inbetter.homework.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {

    Map<Integer, Integer> frequencyMap;
    Map<Integer, Stack<Integer>> map;
    int maximumFrequency;

    public FreqStack() {
        frequencyMap = new HashMap<>();
        map = new HashMap<>();
        maximumFrequency = 0;
    }

    public void push(int val) {
        int count = frequencyMap.getOrDefault(val, 0) + 1;
        frequencyMap.put(val, count);
        maximumFrequency = Math.max(maximumFrequency, count);
        if (!map.containsKey(count)) {
            map.put(count, new Stack<>());
        }
        map.get(count).push(val);
    }

    public int pop() {
        int val = map.get(maximumFrequency).pop();
        frequencyMap.put(val, frequencyMap.get(val) - 1);
        if (map.get(maximumFrequency).size() == 0) {
            maximumFrequency--;
        }
        return val;
    }

}
