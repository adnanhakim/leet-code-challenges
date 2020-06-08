package JuneChallenges;

/*
June 8

Question: Power of Two
Given an integer, write a function to determine if it is a power of two.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3354/
*/

class June8 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        while (n % 2 == 0)
            n /= 2;

        return n == 1;

        // Alternate way using Bit Manipulation
        // return (n & (-n)) == n;
    }
}
