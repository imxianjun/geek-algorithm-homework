package com.inbetter.homework.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {

    private List<Integer>[] container = null;
    private int capacity = 1000;
    private double loadFactor = 0.75;
    private int count;

    public MyHashSet() {
        container = new LinkedList[capacity];
    }

    public void add(int key) {
        if (this.contains(key)) {
            return;
        }
        if (loadFactor * capacity == count) {
            count = 0;
            capacity *= 2;
            List<Integer>[] oldContainer = container;
            container = new LinkedList[capacity];
            for (int i = 0; i < oldContainer.length; i++) {
                List<Integer> list = oldContainer[i];
                if (list != null) {
                    for (Integer element : list) {
                        this.add(element);
                    }
                }
            }
        }
        int hash = key % capacity;
        if (container[hash] == null) {
            container[hash] = new LinkedList<>();
        }
        container[hash].add(key);
        count++;
    }

    public void remove(int key) {
        int hash = key % capacity;
        List<Integer> list = container[hash];
        if (list != null) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == key) {
                    iterator.remove();
                    count--;
                    break;
                }
            }
        }
    }

    public boolean contains(int key) {
        int hash = key % capacity;
        List<Integer> list = container[hash];
        if (list != null) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == key) {
                    return true;
                }
            }
        }
        return false;
    }

}
