package AugustChallenges;

import java.util.ArrayList;
import java.util.List;

/*
August 6

Question: Find All Duplicates in an Array
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3414/
*/

class August6 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                result.add(index + 1);
            } else nums[index] = -nums[index];
        }

        return result;
    }
}
