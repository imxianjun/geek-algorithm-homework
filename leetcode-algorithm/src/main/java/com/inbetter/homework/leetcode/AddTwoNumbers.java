package com.inbetter.homework.leetcode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p = null, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry % 10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        BigInteger a = BigInteger.ZERO, b = BigInteger.ZERO;
//        int count = 0;
//        while (l1 != null) {
//            a = a.add(BigInteger.valueOf(l1.val * Math.round((Math.pow(10, count)))));
//            l1 = l1.next;
//            count++;
//        }
//        count = 0;
//        while (l2 != null) {
//            b = a.add(BigInteger.valueOf(l2.val * Math.round((Math.pow(10, count)))));
//            l2 = l2.next;
//            count++;
//        }
//        BigInteger sum = a.add(b);
//        if (sum.equals(0)) {
//            return new ListNode(0);
//        }
//        List<Integer> list = new ArrayList<>();
//        char[] chars = String.valueOf(sum).toCharArray();
//        System.out.println(chars);
//        for (char c : chars) {
//            list.add(Integer.parseInt(String.valueOf(c)));
//        }
//        ListNode next = null, current = null;
//        for (int i = 0; i < list.size(); i++) {
//            current = new ListNode(list.get(i));
//            current.next = next;
//            next = current;
//        }
//        return current;
//    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
