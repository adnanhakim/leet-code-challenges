package MayChallenges;

/*
May 31

Question: Edit Distance
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
You have the following 3 operations permitted on a word:
1 -> Insert a character
2 -> Delete a character
3 -> Replace a character

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3346/
*/

class May31 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        return dp[m][n];
    }
}
