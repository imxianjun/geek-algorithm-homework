package com.inbetter.homework.leetcode;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AdjacentValueLookup {

    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        Integer[] values = new Integer[n + 1];
        values[0] = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            int value = scanner.nextInt();
            map.put(value, i);
            values[i] = value;
        }

        Integer[] indexes = new Integer[n + 1];
        indexes[0] = 0;
        for (int i = 1; i <= n; i++) {
            indexes[i] = map.get(values[i]);
        }

        Integer[] integers = map.values().toArray(new Integer[n]);

        for (int i = 0; i < integers.length; i++) {
            indexes[i + 1] = integers[i];
        }

        findMinimumValues(values, indexes);
    }

    private static void findMinimumValues(Integer[] values, Integer[] indexes) {
        // 保护节点
        Node head = new Node(values[indexes[1]] - (int) 1e9);// 比最小的数再小1e9 如果是Integer.MIN_VALUE，计算减法时会溢出
        Node tail = new Node(values[indexes[n]] + (int) 1e9);// 比最大的数再大1e9
        head.next = tail;
        tail.pre = head;
        //定义数组pos快速访问链表
        Node[] pos = new Node[n + 1];
        //将数组中的数字按排序加入链表
        for (int i = 1; i <= n; i++) {
            pos[indexes[i]] = addNode(tail.pre, values[indexes[i]], indexes[i]);
        }
        //定义结果集，从后往前计算结果
        int[] ans = new int[n + 1];
        for (int i = n; i > 1; i--) {
            Node curr = pos[i];
            if (values[i] - curr.pre.val <= curr.next.val - values[i]) {
                ans[i] = curr.pre.idx;
            } else {
                ans[i] = curr.next.idx;
            }
            deleteNode(curr);
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(Math.abs(values[ans[i]] - values[i]) + " " + ans[i]);
        }
    }

    //双链表插入模板，在node后面插入新节点
    static Node addNode(Node node, int val, int idx) {
        Node newNode = new Node(val, idx);
        newNode.next = node.next;
        node.next.pre = newNode;
        newNode.pre = node;
        node.next = newNode;
        return newNode;
    }

    // 双链表删除模板
    static void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node = node.next = node.pre = null;
    }

    static class Node {
        int val;
        int idx;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

}