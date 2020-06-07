package JuneChallenges;

/*
June 7

Question: Coin Change 2
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3353/
*/

class June7 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin: coins)
            for (int j = 1; j <= amount; j++)
                if (j >= coin)
                    dp[j] += dp[j - coin];

        return dp[amount];
    }
}
