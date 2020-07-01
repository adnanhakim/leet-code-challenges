package JulyChallenges;

/*
July 1

Question: Arranging Coins
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
Given n, find the total number of full staircase rows that can be formed.
n is a non-negative integer and fits within the range of a 32-bit signed integer.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/
*/

class July1 {
    // Solution 1: Time: O(log N) Space: O(1)
    public int arrangeCoins(int n) {
        int left = 0, right = n;
        long mid, curr;

        while (left <= right) {
            mid = left + (right - left) / 2;
            curr = (mid * (mid + 1)) / 2;

            if (curr == n) return (int) mid;

            if (n < curr)
                right = (int) mid - 1;
            else left = (int) mid + 1;
        }

        return right;
    }

    // Solution 2: Time: O(1) Space: O(1) using Complete the Square method
    public int arrangeCoins2(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }
}
