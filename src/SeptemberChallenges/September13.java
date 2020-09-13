package SeptemberChallenges;

import java.util.ArrayList;
import java.util.List;

/*
September 13

Question: Insert Interval
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3458/
*/

class September13 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            int[][] ans = new int[1][2];
            ans[0] = newInterval;
            return ans;
        }

        int index = 0;
        while (index < intervals.length && newInterval[0] > intervals[index][1]) {
            res.add(intervals[index]);
            index++;
        }

        while (index < intervals.length && newInterval[1] >= intervals[index][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        res.add(newInterval);
        while (index < intervals.length) {
            res.add(intervals[index]);
            index++;
        }

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);

        return ans;
    }
}
