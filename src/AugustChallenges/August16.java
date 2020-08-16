package AugustChallenges;

/*
August 16

Question: Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3426/
*/

class August16 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int K = 2;
        int[][] dp = new int[K + 1][prices.length];

        for (int i = 1; i <= K; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[K][prices.length - 1];
    }
}