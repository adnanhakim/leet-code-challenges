package JuneChallenges;

/*
June 22

Question: Single Number II
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3368/
*/

class June22 {
    public int singleNumber(int[] nums) {
        // Once contains bits occurring 1, 4, 7... times
        // Twice contains bits occurring 2, 5, 8... times
        // Thrice contains bits occurring 3, 6, 9... times
        int once = 0, twice = 0, thrice;

        for (int num: nums) {
            // Twice now contains bits occurring twice & thrice
            twice = twice | (once & num);

            // Once now contains bits occurring once or thrice
            once = once ^ num;

            // To get bits occurring thrice
            thrice = once & twice;

            // Removing bits occurring thrice
            once &= ~thrice;
            twice &= ~thrice;
        }

        return once;
    }
}
