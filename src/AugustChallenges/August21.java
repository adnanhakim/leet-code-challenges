package AugustChallenges;

/*
August 21

Question: Sort Array By Parity
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
You may return any answer array that satisfies this condition.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3431/
*/

class August21 {
    public int[] sortArrayByParity(int[] A) {
        int index = 0;

        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) != 1) {
                int temp = A[i];
                A[i] = A[index];
                A[index++] = temp;
            }
        }

        return A;
    }
}
