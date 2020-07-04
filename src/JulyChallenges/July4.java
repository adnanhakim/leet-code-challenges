package JulyChallenges;

/*
July 4

Question: Ugly Number II
Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3380/
*/

class July4 {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int ptr2 = 0, ptr3 = 0, ptr5 = 0, next2, next3, next5;

        for (int count = 1; count < n; count++) {
            next2 = ugly[ptr2] * 2;
            next3 = ugly[ptr3] * 3;
            next5 = ugly[ptr5] * 5;

            int next = Math.min(next2, Math.min(next3, next5));

            if (next == next2) ptr2++;
            if (next == next3) ptr3++;
            if (next == next5) ptr5++;

            ugly[count] = next;
        }

        return ugly[n - 1];
    }
}
