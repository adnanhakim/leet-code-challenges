package JulyChallenges;

/*
July 23

Question: Single Number III
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3399/
*/

class July23 {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int n : nums)
            bitmask ^= n;

        int diff = bitmask & (-bitmask);

        int x = 0;
        for (int n : nums) {
            if ((diff & n) != 0)
                x ^= n;
        }

        return new int[]{x, bitmask ^ x};
    }
}
