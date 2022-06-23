package com.inbetter.homework.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleIII {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0, totalTime = 0;
        for (int[] course : courses) {
            int time = course[0], endDate = course[1];
            queue.offer(time);
            totalTime += time;
            count++;
            while (totalTime > endDate) {
                totalTime -= queue.poll();
                count--;
            }
        }
        return count;
    }

}
