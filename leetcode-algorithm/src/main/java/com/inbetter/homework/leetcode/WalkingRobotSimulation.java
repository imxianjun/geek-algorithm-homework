package com.inbetter.homework.leetcode;

import java.util.*;

public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        int maximumEuclideanDistance = 0;

        int myDir = 0;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int numDirections = 4;
        int[] robotPos = new int[]{0, 0};

        Map<Integer, List<Integer>> columnObstacleMap = new HashMap<>();
        for (int i = 0; i < obstacles.length; i++) {
            int[] obstacle = obstacles[i];
            int x = obstacle[0];
            int y = obstacle[1];
            List<Integer> column;
            if (!columnObstacleMap.containsKey(x)) {
                column = new LinkedList<>();
            } else {
                column = columnObstacleMap.get(x);
            }
            column.add(y);
            columnObstacleMap.put(x, column);
        }

        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if (command == -2) {
                myDir = ((myDir - 1) + numDirections) % numDirections;
            } else if (command == -1) {
                myDir = ((myDir + 1) + numDirections) % numDirections;
            } else {
                int step = command;
                for (int j = 0; j < step; j++) {
                    int[] nextStep = new int[]{robotPos[0] + directions[myDir][0], robotPos[1] + directions[myDir][1]};
                    boolean hitObstacle = false;
                    if (columnObstacleMap.containsKey(nextStep[0])) {
                        List<Integer> columns = columnObstacleMap.get(nextStep[0]);
                        Iterator<Integer> iterator = columns.iterator();
                        while (iterator.hasNext()) {
                            int myY = iterator.next();
                            if (myY == nextStep[1]) {
                                hitObstacle = true;
                                break;
                            }
                        }
                    }
                    if (hitObstacle) {
                        continue;
                    } else {
                        int currentEuclideanDistance = (int) Math.pow(nextStep[0], 2) + (int) Math.pow(nextStep[1], 2);
                        maximumEuclideanDistance = Math.max(maximumEuclideanDistance, currentEuclideanDistance);
                        robotPos[0] = nextStep[0];
                        robotPos[1] = nextStep[1];
                    }
                }
            }
        }
        return maximumEuclideanDistance;
    }

}
