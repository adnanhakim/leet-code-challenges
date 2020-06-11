package MayChallenges;

/*
May 12

Question: Single Element in a Sorted Array
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
Follow up: Your solution should run in O(log n) time and O(1) space.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
*/

class May12 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1])
                    right = mid - 2;
                else if (nums[mid] == nums[mid + 1])
                    left = mid + 2;
                else return nums[mid];
            } else {
                if (nums[mid] == nums[mid - 1])
                    left = mid + 1;
                else right = mid - 1;
            }
        }

        return nums[left];
    }
}
