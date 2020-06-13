package JuneChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
June 13

Question: Largest Divisible Subset
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/
*/

class June13 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();

        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        int n = nums.length, maxIndex = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;      // Initialize array with 1 (Since a no itself is a subset)
            for (int j = i - 1; j >= 0; j--)
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxIndex = dp[i] > dp[maxIndex] ?  i :  maxIndex;
                }
        }

        int num = nums[maxIndex];
        int count = dp[maxIndex];
        for (int i = maxIndex; i >= 0; i--){
            if (num % nums[i] == 0 && dp[i] == count){
                res.add(nums[i]);
                num = nums[i];
                count--;
            }
        }

        Collections.reverse(res);
        return res;
    }
}
