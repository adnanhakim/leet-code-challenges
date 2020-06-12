package MayChallenges;

import java.util.ArrayList;
import java.util.List;

/*
May 19

Question: Online Stock Span
Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].

https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/
*/

class May19 {
    List<Integer> prices, spans;

    public May19() {
        prices = new ArrayList<>();
        spans = new ArrayList<>();
    }

    public int next(int price) {
        int index = prices.size() - 1;
        while (index >= 0 && price >= prices.get(index))
            index -= spans.get(index);

        prices.add(price);
        int span = prices.size() - 1 - index;
        spans.add(span);
        return span;
    }
}

/*
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
