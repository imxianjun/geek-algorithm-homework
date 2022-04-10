package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public int calPoints(String[] ops) {
        int i = 0;
        List<Integer> scores = new ArrayList<Integer>();
        for (String op : ops) {
            if ("C".equals(op)) {
                scores.remove(i - 1);
                i--;
            } else if ("D".equals(op)) {
                scores.add(2 * scores.get(i - 1));
                i++;
            } else if ("+".equals(op)) {
                scores.add(scores.get(i - 1) + scores.get(i - 2));
                i++;
            } else {
                scores.add(Integer.parseInt(op));
                i++;
            }
        }
        return scores.stream().mapToInt(e -> e).sum();
    }

    public static void main(String[] args) {
        String[] ops = new String[]{"5", "2", "C", "D", "+"};
        int i = new BaseballGame().calPoints(ops);
        System.out.println(i);
    }

}
