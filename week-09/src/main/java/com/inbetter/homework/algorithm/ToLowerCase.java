package com.inbetter.homework.algorithm;

import java.util.stream.IntStream;

public class ToLowerCase {

    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        IntStream.range(0, chars.length)
                .filter(i -> 'A' <= chars[i] && chars[i] <= 'Z')
                .forEach(i -> chars[i] = (char) (chars[i] - 'A' + 'a'));
        return new String(chars);
    }

}
