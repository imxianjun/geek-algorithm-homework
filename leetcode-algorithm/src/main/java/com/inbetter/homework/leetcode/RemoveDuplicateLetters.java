package com.inbetter.homework.leetcode;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] res = new int[26];
        boolean[] visited = new boolean[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            res[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int index;
        for (char c : chars) {
            index = c - 'a';
            res[index]--;
            if (visited[index]) {
                continue;
            }
            while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) && res[sb.charAt(sb.length() - 1) - 'a'] != 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            visited[index] = true;
        }
        return sb.toString();
    }

//    public String removeDuplicateLetters(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            Character c = s.charAt(i);
//            if (stack.contains(c)) {
//                continue;
//            }
//            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1) {
//                stack.pop();
//            }
//            stack.push(c);
//        }
//        char chars[] = new char[stack.size()];
//        for (int i = 0; i < stack.size(); i++) {
//            chars[i] = stack.get(i);
//        }
//        return new String(chars);
//    }

}
