package com.inbetter.homework.leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    /**
     * Uid - {StationName, Time}
     */
    private Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>();

    /**
     * RouteName - {TotalTime, Count}
     */
    private Map<String, Pair<Integer, Integer>> routeMap = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> previousCheckIn = checkInMap.get(id);
        // 优化点：使用后删除它，使 HashMap 不会变大
        checkInMap.remove(id);

        String routeKey = getRouteKey(previousCheckIn.getKey(), stationName);
        int totalTime = t - previousCheckIn.getValue();

        Pair<Integer, Integer> routePair = routeMap.getOrDefault(routeKey, new Pair<>(0, 0));
        routeMap.put(routeKey, new Pair<>(routePair.getKey() + totalTime, routePair.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = getRouteKey(startStation, endStation);
        Pair<Integer, Integer> routePair = routeMap.get(routeKey);
        return 1.0 * routePair.getKey() / routePair.getValue();
    }

    private String getRouteKey(String startStation, String endStation) {
        return startStation + "_" + endStation;
    }

}
