package AugustChallenges;

import java.util.TreeMap;

/*
August 27

Question: Find Right Interval
Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.
Note:
1 -> You may assume the interval's end point is always bigger than its start point.
2 -> You may assume none of these intervals have the same start point.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3438/
*/

class August27 {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++)
            treeMap.put(intervals[i][0], i);

        for (int i = 0; i < intervals.length; i++) {
            Integer key = treeMap.ceilingKey(intervals[i][1]);
            result[i] = key != null ? treeMap.get(key) : -1;
        }

        return result;
    }
}
