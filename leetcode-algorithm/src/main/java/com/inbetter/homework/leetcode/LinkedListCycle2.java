package com.inbetter.homework.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head.next)) {
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

}
