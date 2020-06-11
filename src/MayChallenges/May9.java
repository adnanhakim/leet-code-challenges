package MayChallenges;

/*
May 9

Question: Valid Perfect Square
Given a positive integer num, write a function which returns True if num is a perfect square else False.
Follow up: Do not use any built-in library function such as sqrt.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/
*/

class May9 {
    public boolean isPerfectSquare(int num) {
        int lastDigit = num % 10;
        if (lastDigit == 2 || lastDigit == 3 || lastDigit == 7 ||lastDigit == 8)
            return false;

        int left = 1, right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) return true;
            else if (square > num) right = (int) mid - 1;
            else left = (int) mid + 1;
        }

        return false;
    }
}
