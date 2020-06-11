package MayChallenges;

/*
May 4

Question: Number Complement
Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3319/
*/


class May4 {
    public int findComplement(int num) {
        int length = (int) Math.floor(Math.log(num) / Math.log(2)) + 1;
        return (int) (Math.pow(2, length) - 1 - num);
    }
}

/*
Let's say the number is 5 (101)
Length of binary = 3
2^3 = 8 - 1 = 7 (111)
    1   1   1
-   1   0   1
----------------
    0   1   0   (2)
----------------

Maximum value of same no of digits (all 1s) - number = 1s complement of a number
*/