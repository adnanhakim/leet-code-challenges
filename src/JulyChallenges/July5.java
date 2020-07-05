package JulyChallenges;

/*
July 5

Question: Hamming Distance
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3381/
*/

class July5 {
    public int hammingDistance(int x, int y) {
        int result = 0;
        while (x != 0 || y != 0) {
            result += (x % 2) ^ (y % 2);
            x >>>= 1;
            y >>>= 1;
        }

        return result;
    }
}
