package MayChallenges;

/*
May 28

Question: Counting Bits
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/
*/

class May28 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0)
                dp[i] = dp[i / 2];
            else dp[i] = 1 + dp[i / 2];
        }

        return dp;
    }
}
