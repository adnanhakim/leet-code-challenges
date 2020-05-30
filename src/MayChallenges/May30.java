package MayChallenges;

import java.util.PriorityQueue;

/*
May 30

Question: K Closest Points to Origin
We have a list of points on the plane. Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

https://leetcode.com/explore/featured/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3345/
*/

class May30 {
    static class Point {
        int x;
        int y;
        double distance;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(Math.pow(Math.abs(x), 2) + Math.pow(Math.abs(y), 2));
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        int[][] closest = new int[K][2];

        PriorityQueue<Point> queue = new PriorityQueue<Point>((p1, p2) -> {
            return (int) (p1.distance * 100 - p2.distance * 100);
        });

        for (int i = 0; i < points.length; i++) {
            Point point = new Point(points[i][0], points[i][1]);
            System.out.println(point.distance);
            queue.add(point);
        }

        for (int i = 0; i < K; i++) {
            Point point = queue.remove();
            closest[i][0] = point.x;
            closest[i][1] = point.y;
        }

        return closest;
    }
}
