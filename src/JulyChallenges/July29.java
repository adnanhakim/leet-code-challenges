package JulyChallenges;

/*
July 29

Question: Best Time to Buy and Sell Stock with Cooldown
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3405/
*/

class July29 {
    public int maxProfit(int[] prices) {
        long noStock = 0, hasStock = Integer.MIN_VALUE, prevNoStock = 0;
        for (int price : prices) {
            long tmp = noStock;
            noStock = Math.max(noStock, hasStock + price);
            hasStock = Math.max(hasStock, prevNoStock - price);
            prevNoStock = tmp;
        }
        return (int) noStock;
    }
}
