package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * excellent answer
 */
public class CombinationsExcellentAnswer {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        combine(list, new ArrayList<Integer>(), 1, n, k);
        return list;
    }

    private void combine(List<List<Integer>> list, List<Integer> temp, int start, int n, int k) {
        if (k == 0) {
            list.add(new ArrayList<Integer>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);
            combine(list, temp, i + 1, n, k - 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationsExcellentAnswer combinations = new CombinationsExcellentAnswer();
        List<List<Integer>> combine = combinations.combine(4, 2);
        for (List<Integer> integers : combine) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
