package MayChallenges;

/*
May 8

Question: Check If It Is a Straight Line
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/
*/

class May8 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length <= 2) return true;

        double slope = getSlope(coordinates[0], coordinates[1]);

        for (int i = 2; i < coordinates.length; i++)
            if (getSlope(coordinates[0], coordinates[i]) != slope)
                return false;

        return true;
    }

    public double getSlope(int[] a, int[] b) {
        if (a[0] == b[0]) return Integer.MAX_VALUE;
        return (double) (b[1] - a[1]) / (b[0] - a[0]);
    }
}
