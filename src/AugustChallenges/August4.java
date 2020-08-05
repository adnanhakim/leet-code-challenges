package AugustChallenges;

/*
August 4

Question: Power of Four
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3412/
*/

class August4 {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }
}
