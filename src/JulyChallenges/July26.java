package JulyChallenges;

/*
July 26

Question: Add Digits
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3402/
*/

class July26 {
    public int addDigits(int num) {
        return 1 + --num % 9;
    }
}
