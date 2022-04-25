package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

    private List<Integer> container = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        container = new ArrayList<>();
        while (iterator.hasNext()) {
            container.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return container.get(0);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ans = container.get(0);
        container.remove(0);
        return ans;
    }

    @Override
    public boolean hasNext() {
        return !container.isEmpty();
    }

}
