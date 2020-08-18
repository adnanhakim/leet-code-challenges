package AugustChallenges;

import java.util.ArrayList;
import java.util.List;

/*
August 18

Question: Numbers With Same Consecutive Differences
Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.
Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.
You may return the answer in any order.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3428/
*/

class August18 {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> results = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            dfs(N - 1, K, i, results);

        int[] arr = new int[results.size()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = results.get(i);

        return arr;
    }

    private void dfs(int N, int K, int currNum, List<Integer> results) {
        if (N == 0) {
            results.add(currNum);
            return;
        }

        int lastDigit = currNum % 10;
        int increment = lastDigit + K;
        int decrement = lastDigit - K;

        if (increment >= 0 && increment < 10) {
            int newNum = currNum * 10 + increment;
            dfs(N - 1, K, newNum, results);
        }

        // To avoid repeating same values
        if (K != 0 && decrement >= 0 && decrement < 10) {
            int newNum = currNum * 10 + decrement;
            dfs(N - 1, K, newNum, results);
        }
    }
}
