package AugustChallenges;

/*
August 25

Question: Minimum Cost For Tickets
In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
Train tickets are sold in 3 different ways:
1 -> a 1-day pass is sold for costs[0] dollars;
2 -> a 7-day pass is sold for costs[1] dollars;
3 -> a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3436/
*/

class August25 {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] isTravelDay = new boolean[366];
        for (int day : days)
            isTravelDay[day] = true;

        int[] minCost = new int[366];
        for (int i = 1; i < 366; i++) {
            if (!isTravelDay[i]) {
                minCost[i] = minCost[i - 1];
                continue;
            }

            int min = Integer.MAX_VALUE;
            min = Math.min(min, minCost[Math.max(0, i - 1)] + costs[0]);
            min = Math.min(min, minCost[Math.max(0, i - 7)] + costs[1]);
            min = Math.min(min, minCost[Math.max(0, i - 30)] + costs[2]);
            minCost[i] = min;
        }

        return minCost[365];
    }
}
