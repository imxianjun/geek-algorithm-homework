package com.inbetter.homework.leetcode;

import java.util.*;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String s : path.split("/")) {
            if ("..".equals(s) && !stack.isEmpty()) {
                stack.pop();
            } else {
                if (!set.contains(s)) {
                    stack.push(s);
                }
            }
        }
        String ans = "";
        for (String dir : stack) {
            ans = "/" + dir + ans;
        }
        return ans.isEmpty() ? "/" : ans;
    }

}
