package MayChallenges;

/*
May 6

Question: Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
*/

class May6 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer majority = null;

        for (int num: nums) {
            if (count == 0) majority = num;
            count += (majority == num) ? 1 : -1;
        }

        return majority;
    }
}

/*
Boyer-Moore Voting Algorithm

Step 1: Find majority element
    1 -> count = 0
    2 -> Iterate through all elements
    3 -> If count = 0, majority element = that element
    4 -> If majority element = that element, increment count else decrement count
Step 2: Verify majority element (Not required in this sum as it guarantees a majority element)
    1 -> Iterate through all elements and get count of majority element
    2 -> If count > Floor(n/2) majority element exists
    3 -> Else majority element doesn't exist

Time Complexity: O(n)
Space Complexity: O(1)
*/
