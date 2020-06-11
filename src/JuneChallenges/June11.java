package JuneChallenges;

/*
June 11

Question: Sort Colors
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: You are not suppose to use the library's sort function for this problem.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
*/

class June11 {
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;

        int start = 0, index = 0, end = nums.length - 1;

        while (index <= end && start < end) {
            if (nums[index] == 0) {
                nums[index++] = nums[start];
                nums[start++] = 0;
            } else if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end--] = 2;
            } else index++;
        }
    }
}
