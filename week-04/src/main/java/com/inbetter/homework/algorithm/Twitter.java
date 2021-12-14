package com.inbetter.homework.algorithm;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter {

    List<Pair<Integer, Integer>> tweets;

    Map<Integer, boolean[]> map;

    public Twitter() {
        tweets = new ArrayList<Pair<Integer, Integer>>();
        map = new HashMap<Integer, boolean[]>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(new Pair<Integer, Integer>(userId, tweetId));
        follow(userId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        boolean[] booleans = map.get(userId);
        int cnt = 0;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = tweets.size() - 1; cnt < 10 && i >= 0; i--) {
            Pair<Integer, Integer> pair = tweets.get(i);
            if (booleans[pair.getKey()]) {
                res.add(pair.getValue());
                cnt++;
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        map.putIfAbsent(followerId, new boolean[501]);
        map.get(followerId)[followeeId] = true;
    }

    public void unfollow(int followerId, int followeeId) {
        map.get(followerId)[followeeId] = false;
    }

}
