package AugustChallenges;

import java.util.Arrays;
import java.util.Comparator;

/*
August 15

Question: Non-overlapping Intervals
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3425/
*/

class August15 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int end = intervals[intervals.length - 1][0];
        int count = 1;
        for (int i = intervals.length - 2; i >= 0; i--) {
            if (end >= intervals[i][1]) {
                end = intervals[i][0];
                count++;
            }
        }

        return intervals.length - count;
    }
}
