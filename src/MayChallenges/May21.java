package MayChallenges;

/*
May 21

Question: Count Square Submatrices with All Ones
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/
*/

class May21 {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        int sum = 0;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = matrix[i][j];
                else if (matrix[i][j] == 1)
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                sum += dp[i][j];
            }

        return sum;
    }
}
