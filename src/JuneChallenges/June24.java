package JuneChallenges;

/*
June 24

Question: Unique Binary Search Trees
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3370/
*/

class June24 {
    public int numTrees(int n) {
        if (n < 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i - j - 1];

        return dp[n];
    }
}
