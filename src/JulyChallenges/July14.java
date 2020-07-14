package JulyChallenges;

/*
July 14

Question: Angle Between Hands of a Clock
Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/
*/

class July14 {
    public double angleClock(int hour, int minutes) {
        double angle = Math.abs((30 * hour) - (5.5 * minutes));
        return Math.min(angle, 360 - angle);
    }
}
