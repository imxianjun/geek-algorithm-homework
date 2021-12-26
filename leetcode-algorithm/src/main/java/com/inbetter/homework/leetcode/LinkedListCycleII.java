package com.inbetter.homework.leetcode;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode walker = head, runner = head, entry = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                while (walker != entry) {
                    walker = walker.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
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
