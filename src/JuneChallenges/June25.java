package JuneChallenges;

/*
June 25

Question: Find the Duplicate Number
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
Note:
1 -> You must not modify the array (assume the array is read only).
2 -> You must use only constant, O(1) extra space.
3 -> Your runtime complexity should be less than O(n2).
4 -> There is only one duplicate number in the array, but it could be repeated more than once.

https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3371/
*/

class June25 {
    // Floyd's tortoise and hare algorithm
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];

        // Tortoise will take 1 step at a time, whereas hare will take 2 steps
        tortoise = nums[tortoise];
        hare = nums[nums[hare]];

        // They will meet at a certain point (not guaranteed to be the entrance of the loop)
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }

        // To find the entrance of the loop, restart tortoise and slow down hare
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return tortoise;
    }
}
