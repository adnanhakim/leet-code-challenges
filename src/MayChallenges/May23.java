package MayChallenges;

import java.util.ArrayList;

/*
May 23

Question: Interval List Intersections
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.

https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/
*/

class May23 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0, j = 0; i < A.length && j < B.length; ) {
            int[] arrA = A[i];
            int[] arrB = B[j];

            if (arrA[0] > arrB[1]) {
                j++;
                continue;
            } else if (arrB[0] > arrA[1]) {
                i++;
                continue;
            }

            ArrayList<Integer> interval = new ArrayList<>();
            interval.add(Math.max(arrA[0], arrB[0]));
            interval.add(Math.min(arrA[1], arrB[1]));
            lists.add(interval);

            if (arrA[1] > arrB[1]) j++;
            else if (arrA[1] < arrB[1]) i++;
            else {
                i++;
                j++;
            }
        }

        int[][] arr = new int[lists.size()][2];
        for(int i = 0; i < lists.size(); i++) {
            arr[i][0] = lists.get(i).get(0);
            arr[i][1] = lists.get(i).get(1);
        }

        return arr;
    }
}