package com.inbetter.homework.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses3 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, 0, 0, n, "");
        return ans;
    }

    private void helper(List<String> ans, int left, int right, int n, String s) {
        if (left == n && right == n) {
            ans.add(s);
            return;
        }

        if (left < n) {
            helper(ans, left + 1, right, n, s + "(");
        }

        if (left > right && right < n) {
            helper(ans, left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        GenerateParentheses3 generateParentheses3 = new GenerateParentheses3();
        List<String> list = generateParentheses3.generateParenthesis(3);
        list.stream().parallel().forEach(System.out::println);
    }

}
