package JuneChallenges;

import java.util.Arrays;

/*
June 3

Question: Two City Scheduling
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
*/

class June3 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> (o1[0] - o1[1]) - (o2[0] - o2[1]));
        int minCost = 0, i;

        for (i = 0; i < costs.length / 2; i++)
            minCost += costs[i][0];

        for (; i < costs.length; i++)
            minCost += costs[i][1];

        return minCost;
    }
}
