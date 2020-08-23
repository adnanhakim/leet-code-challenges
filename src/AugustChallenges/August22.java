package AugustChallenges;

import java.util.Random;
import java.util.TreeMap;

/*
August 22

Question: Random Point in Non-overlapping Rectangles
Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.
Note:
1 -> An integer point is a point that has integer coordinates.
2 -> A point on the perimeter of a rectangle is included in the space covered by the rectangles.
3 -> ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
4 -> length and width of each rectangle does not exceed 2000.
5 -> 1 <= rects.length <= 100
6 -> pick return a point as an array of integer coordinates [p_x, p_y]
7 -> pick is called at most 10000 times.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3433/
*/

class August22 {
    private int[][] rects;
    private Random random;
    private TreeMap<Integer, Integer> treeMap;
    private int area;

    public August22(int[][] rects) {
        this.rects = rects;
        random = new Random();
        treeMap = new TreeMap<>();

        for (int i = 0; i < rects.length; i++) {
            area += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            treeMap.put(area, i);
        }
    }

    public int[] pick() {
        int randomInt = random.nextInt(area);
        int key = treeMap.higherKey(randomInt);
        int[] rect = rects[treeMap.get(key)];
        int x = rect[0] + (key - randomInt - 1) % (rect[2] - rect[0] + 1);
        int y = rect[1] + (key - randomInt - 1) / (rect[2] - rect[0] + 1);
        return new int[]{x, y};
    }
}
