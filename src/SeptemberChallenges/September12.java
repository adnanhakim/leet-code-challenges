package SeptemberChallenges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
September 12

Question: Combination Sum III
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
Note:
1 -> All numbers will be positive integers.
2 -> The solution set must not contain duplicate combinations.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3457/
*/

class September12 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        backtrack(n, k, comb, 0, results);
        return results;
    }

    private void backtrack(int remain, int k, LinkedList<Integer> comb, int next_start, List<List<Integer>> results) {
        if (remain == 0 && comb.size() == k) {
            results.add(new ArrayList<>(comb));
            return;
        } else if (remain < 0 || comb.size() == k)
            return;

        for (int i = next_start; i < 9; ++i) {
            comb.add(i + 1);
            backtrack(remain - i - 1, k, comb, i + 1, results);
            comb.removeLast();
        }
    }
}
