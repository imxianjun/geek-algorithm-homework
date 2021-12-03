package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            list.add(current.toString());
            return;
        }

        if (open < max) {
            current.append('(');
            backtrack(list, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            backtrack(list, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new GenerateParentheses().generateParenthesis(1);
        for (String value : list) {
            System.out.println(value);
        }
        System.out.println("=========");
        list = new GenerateParentheses().generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }

}
