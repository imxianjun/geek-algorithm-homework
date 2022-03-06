package com.inbetter.homework.leetcode;

public class CountAllValidPickupAndDeliveryOptions {

    public int countOrders(int n) {
        long ans = 1L, mod = (long) 1e9 + 7;
        for (int i = 1; i <= n; i++) {
            ans = ans * (2 * i - 1) * i % mod;
        }
        return (int) ans;
    }

}
