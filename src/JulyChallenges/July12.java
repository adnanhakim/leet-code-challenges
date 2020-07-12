package JulyChallenges;

import java.util.LinkedList;
import java.util.Queue;

/*
July 12

Question: Reverse Bits
Reverse bits of a given 32 bits unsigned integer.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3388/
*/

class July12 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();

        // 32 times
        for (int i = 0; i < 32; i++) {
            int digit = n & 1;
            queue.add(digit);
            n >>= 1;
        }

        // 32 times
        while (!queue.isEmpty()) {
            result <<= 1;
            result = result | queue.poll();
        }

        return result;
    }
}
