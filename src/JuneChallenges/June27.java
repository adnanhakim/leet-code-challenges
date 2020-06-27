package JuneChallenges;

/*
June 27

Question: Perfect Squares
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3373/
*/

class June27 {
    public int numSquares(int n) {
        int weightCount = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i] = i;

        for (int i = 1; i < weightCount; i++)
            for (int j = 1; j <= n; j++) {
                int square = (i + 1) * (i + 1);
                if (square <= j)
                    dp[j] = Math.min(dp[j], 1 + dp[j - square]);
            }


        return dp[n];
    }
}
