package com.inbetter.homework.algorithm;

import java.util.Scanner;

public class AdjacentValueLookup {

    private static int length;

    private static int[] array;

    private static int[] rank;

    /**
     * todo cannot solve this problem now
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        length = scanner.nextInt();
        array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        rank = new int[length];

    }

}
