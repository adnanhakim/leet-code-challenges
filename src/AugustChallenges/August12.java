package AugustChallenges;

import java.util.ArrayList;
import java.util.List;

/*
August 12

Question: Pascal's Triangle II
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
Note that the row index starts from 0.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3421/
*/

class August12 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        if (rowIndex == 0) {
            row.add(1);
            return row;
        }

        List<Integer> prevRow = getRow(rowIndex - 1);
        int n = prevRow.size();

        row.add(1);
        for (int i = 0, j = 1; i < n - 1 && j < n; i++, j++)
            row.add(prevRow.get(i) + prevRow.get(j));
        row.add(1);

        return row;
    }
}
