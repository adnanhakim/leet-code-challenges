package JuneChallenges;

import java.util.PriorityQueue;

/*
June 14

Question: Cheapest Flights Within K Stops
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3360/
*/

class June14 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];

        for (int[] flight : flights)
            graph[flight[0]][flight[1]] = flight[2];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // [destination, cost, remainingStops]
        queue.offer(new int[]{src, 0, K});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int destination = curr[0], cost = curr[1], remainingStops = curr[2];

            if (destination == dst) return cost;

            if (remainingStops >= 0)
                for (int i = 0; i < graph[destination].length; i++)
                    if (graph[destination][i] > 0)
                        queue.offer(new int[]{i, cost + graph[destination][i], remainingStops - 1});
        }

        return -1;
    }
}

/*
Adjacency Matrix
Dijsktra's Algorithm
*/