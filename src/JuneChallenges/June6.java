package JuneChallenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
June 6

Question: Queue Reconstruction by Height
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/
*/

class June6 {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);

        for(int[] person : people)
            result.add(person[1], person);

        return result.toArray(new int[result.size()][]);
    }
}
