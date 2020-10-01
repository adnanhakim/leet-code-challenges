package SeptemberChallenges;

/*
September 17

Question: Robot Bounded In Circle
On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:
"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.
Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3463/
*/

class September17 {
    public boolean isRobotBounded(String instructions) {
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // initial position is in the center
        int x = 0, y = 0;
        // facing north
        int index = 0;

        for (char i : instructions.toCharArray()) {
            if (i == 'L')
                index = (index + 3) % 4;
            else if (i == 'R')
                index = (index + 1) % 4;
            else {
                x += directions[index][0];
                y += directions[index][1];
            }
        }

        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (index != 0);
    }
}
