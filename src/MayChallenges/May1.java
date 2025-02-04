package MayChallenges;

/*
May 1

Question: First Bad Version
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/
*/

class May1 {

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    // To get rid of error
    boolean isBadVersion(int version){
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if(!isBadVersion(mid))
                left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
