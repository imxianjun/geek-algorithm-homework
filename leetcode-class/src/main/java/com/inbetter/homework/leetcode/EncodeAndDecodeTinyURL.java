package com.inbetter.homework.leetcode;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

    private Map<String, String> codeDb = new HashMap<>(), urlDb = new HashMap<>();

    private static String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlDb.containsKey(longUrl)) {
            return urlDb.get(longUrl);
        }
        String code = getCode();
        while (urlDb.containsKey(code)) {
            code = getCode();
        }
        codeDb.put(code, longUrl);
        urlDb.put(longUrl, code);
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeDb.get(shortUrl);
    }

    private String getCode() {
        char[] code = new char[6];
        for (int i = 0; i < 6; i++) {
            code[i] = chars.charAt((int) Math.random() * 62);
        }
        return "http://tinyurl.com/" + String.valueOf(code);
    }

}
