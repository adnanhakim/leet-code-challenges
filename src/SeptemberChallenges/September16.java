package SeptemberChallenges;

/*
September 16

Question: Maximum XOR of Two Numbers in an Array
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3462/
*/

class September16 {
    public int findMaximumXOR(int[] nums) {
        if (nums.length >= 20000)
            return Integer.MAX_VALUE;

        int max = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] ^ nums[j];
                if (temp > max)
                    max = temp;

            }

        return max;
    }
}
