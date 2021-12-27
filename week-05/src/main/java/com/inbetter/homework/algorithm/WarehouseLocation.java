package com.inbetter.homework.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class WarehouseLocation {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = cin.nextInt();
        }
        Arrays.sort(a);
        int ans = 0;
        int pos = a[n >> 1];
        for (int x : a) {
            ans += Math.abs(pos - x);
        }
        System.out.println(ans);
    }

}
