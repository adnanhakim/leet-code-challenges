package MayChallenges;

/*
May 15

Question: Maximum Sum Circular Subarray
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/
*/

class May15 {
    public int maxSubarraySumCircular(int[] A) {
        int totalSum = 0, minEndingAt = 0, maxEndingAt = 0;
        int minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE;

        for (int no : A) {
            totalSum += no;
            maxEndingAt = Math.max(maxEndingAt + no, no);
            maxSum = Math.max(maxEndingAt, maxSum);
            minEndingAt = Math.min(minEndingAt + no, no);
            minSum = Math.min(minEndingAt, minSum);
        }

        return (maxSum > 0) ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
}

// Kadane's Algorithm