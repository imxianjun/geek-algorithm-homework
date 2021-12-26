package com.inbetter.homework.algorithm;

public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return reached(maze, start[0], start[1], destination, visited);
    }

    private boolean reached(int[][] maze, int i, int j, int[] destination, boolean[][] visited) {
        if (i == destination[0] && j == destination[1]) {
            return true;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        int[][] dirs = new int[4][2];
        dirs[0] = new int[]{0, 1};
        dirs[1] = new int[]{1, 0};
        dirs[2] = new int[]{0, -1};
        dirs[3] = new int[]{-1, 0};
        for (int[] dir : dirs) {
            int x = i, y = j;
            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x = x + dir[0];
                y = y + dir[1];
            }
            x = x - dir[0];
            y = y - dir[1];
            if (!visited[x][y] && reached(maze, x, y, destination, visited)) {
                return true;
            }
        }
        return false;
    }

}
