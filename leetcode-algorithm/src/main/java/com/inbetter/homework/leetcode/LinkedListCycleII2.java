package com.inbetter.homework.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII2 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            if (nodes.contains(currentNode)) {
                return currentNode;
            }
            nodes.add(currentNode);
            currentNode = currentNode.next;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}