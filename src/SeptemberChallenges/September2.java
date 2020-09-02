package SeptemberChallenges;

/*
September 2

Question: Contains Duplicate III
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3446/
*/

class September2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0)
            return false;

        if (k >= 10000 && t == 0)
            return false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k; j++) {
                if (j >= nums.length)
                    break;

                if ((long) nums[i] - (long) nums[j] > (long) Integer.MAX_VALUE ||
                        (long) nums[j] - (long) nums[i] > (long) Integer.MAX_VALUE)
                    continue;

                if (Math.abs(nums[i] - nums[j]) <= t)
                    return true;

            }
        }
        return false;
    }
}
