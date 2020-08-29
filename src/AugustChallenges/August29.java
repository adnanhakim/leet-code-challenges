package AugustChallenges;

import java.util.ArrayList;
import java.util.List;

/*
August 29

Question: Pancake Sorting
Given an array of integers A, We need to sort the array performing a series of pancake flips.
In one pancake flip we do the following steps:
1 -> Choose an integer k where 0 <= k < A.length.
2 -> Reverse the sub-array A[0...k].
For example, if A = [3,2,1,4] and we performed a pancake flip choosing k = 2, we reverse the sub-array [3,2,1], so A = [1,2,3,4] after the pancake flip at k = 2.
Return an array of the k-values of the pancake flips that should be performed in order to sort A. Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3441/
*/

class August29 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();

        for (int i = A.length; i > 0; i--) {
            int index = find(A, i);
            if (index == i - 1)
                continue;

            if (index != 0) {
                result.add(index + 1);
                flip(A, index + 1);
            }

            result.add(i);
            flip(A, i);
        }

        return result;
    }

    private void flip(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    private int find(int[] A, int target) {
        for (int i = 0; i < A.length; i++)
            if (A[i] == target)
                return i;
        return -1;
    }
}
