package com.inbetter.homework.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> count = new HashMap<String, Integer>();
        for (String cpdomain : cpdomains) {
            int i = cpdomain.indexOf(' ');
            int n = Integer.parseInt(cpdomain.substring(0, i));
            String s = cpdomain.substring(i + 1);
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == '.') {
                    String substring = s.substring(j + 1);
                    count.put(substring, count.getOrDefault(substring, 0) + n);
                }
            }
            count.put(s, count.getOrDefault(s, 0) + n);
        }

        List<String> result = new ArrayList<>();
        count.forEach((k, v) -> {
            result.add(v + " " + k);
        });
        return result;
    }

    public static void main(String[] args) {
        String[] ss={"9001 discuss.leetcode.com"};
        new SubdomainVisitCount().subdomainVisits(ss);
    }

}
