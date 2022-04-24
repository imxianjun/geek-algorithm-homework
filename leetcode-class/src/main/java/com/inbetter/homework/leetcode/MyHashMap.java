package com.inbetter.homework.leetcode;

public class MyHashMap {

    private HashNode[] container = null;

    public MyHashMap() {
        container = new HashNode[10000];
    }

    public void put(int key, int value) {
        int index = calculateIndex(key);
        if (container[index] == null) {
            container[index] = new HashNode(-1, -1);
        }
        HashNode previousNode = find(container[index], key);
        if (previousNode.next == null) {
            previousNode.next = new HashNode(key, value);
        } else {
            previousNode.next.value = value;
        }
    }

    public int get(int key) {
        int index = calculateIndex(key);
        if (container[index] == null) {
            return -1;
        }
        HashNode previousNode = find(container[index], key);
        return previousNode.next != null ? previousNode.next.value : -1;
    }

    public void remove(int key) {
        int index = calculateIndex(key);
        if (container[index] != null) {
            HashNode previousNode = find(container[index], key);
            if (previousNode.next != null) {
                previousNode.next = previousNode.next.next;
            }
        }
    }

    private HashNode find(HashNode bucket, int key) {
        HashNode hashNode = bucket, previousNode = null;
        for (; hashNode != null && hashNode.key != key; hashNode = hashNode.next) {
            previousNode = hashNode;
        }
        return previousNode;
    }

    private int calculateIndex(int key) {
        return Integer.hashCode(key) % container.length;
    }

    static class HashNode {

        int key;

        int value;

        HashNode next;

        public HashNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

}
